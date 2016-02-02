#!/usr/bin/env python 

import math
import random
import sys
import getopt
import argparse


def FillLists(numHidden):
	global test, firstInputList, secondInputList, output, inputWeight1, inputWeight2, outputWeight, holdOutNumber, trainingData, secondInput
	
	
	firstInputList = []
	secondInputList = []
	output = []

	inputWeight1 = []
	inputWeight2 = []
	outputWeight = []


	counter = 1

	for line in test:
		words = line.split()

		firstInputList.append(words[0])
		secondInputList.append(words[1])
		output.append(words[2])
		
	while(counter<=numHidden):
		inputWeight1.append(random.uniform(-1,1))
		inputWeight2.append(random.uniform(-1,1))
		outputWeight.append(random.uniform(-1,1))
		counter+=1
	holdOutNumber = secondInput * len(output)
	trainingData = len(output) - holdOutNumber
	return firstInput, secondInput, output, inputWeight1, inputWeight2, outputWeight, holdOutNumber, trainingData


def HFunction(pointer):
	global firstInputList, secondInputList, output, inputWeight1, inputWeight2, outputWeight
	weightPointer = 0
	mathStuff = 0.0

	while weightPointer < firstInput:
		yFirstInput = firstInputList[pointer]
		yFirstWeight = inputWeight1[weightPointer]
		y1 = float(yFirstInput) * yFirstWeight

		ySecondInput = secondInputList[pointer] 
		ySecondWeight = inputWeight2[weightPointer]
		y2 = float(ySecondInput) * ySecondWeight

		y = y1+y2
		mathStuff += outputWeight[weightPointer] * Sigmoid(y)
		weightPointer+=1

	if mathStuff > 1:
		mathStuff = 1
	elif mathStuff < 0:
		mathStuff = 0
	elif mathStuff > 0.1:
		mathStuff = 1

	return mathStuff


def Sigmoid(x):
	sigMath = 0.0

	if x > 500:
		x = 500
	elif x < -500:
		x = -500

	sigMath = 1/(1+math.exp(-x))
	sigMath = round(sigMath)
	#print (sigMath)
	return sigMath



def BackProp(err):
	global firstInput, secondInput, output, inputWeight1, inputWeight2, outputWeight, learningRate, decay

	#learningRate = learningRate * decay
	i = 0

	if err < -1:
		err = -1
	elif err > 1:
		err = 1

	while (i<len(inputWeight1)):
		inputWeight1[i] = inputWeight1[i] + (learningRate * err * -1)
		inputWeight2[i] = inputWeight2[i] + (learningRate * err * -1)
		outputWeight[i] = outputWeight[i] + (learningRate * err * -1)
		i+=1



if __name__=='__main__':

	global firstInputList, secondInputList, output, inputWeight1, inputWeight2, outputWeight, learningRate, decay, secondInput, holdOutNumber, trainingData

	myopts, args = getopt.getopt(sys.argv[1:], "i:o:")

	firstInput=5
	secondInput=.2

	fileName = args[0]

	if(len(args)>2):
		firstInput = float(args[2])
	if(len(args)>4):
		secondInput = float(args[4])

	test = open(fileName,"r")

	trainingCounter = 0
	testingCounter = 0
	errorList = []
	zeroCount = 0
	timesDone = 0
	maxRepeats = 250
	learningRate = .1
	decay = .99

	#Pull from User input
	FillLists(firstInput)
	#print(outputWeight)
	while (timesDone < maxRepeats):
		trainingCounter = 0
		while (trainingCounter < trainingData):

			err1 = HFunction(trainingCounter)
			err2 = output[trainingCounter]
			err = err1- float(err2)

			#print (err1, err2, err)

			#back propogation
			BackProp(err)
			trainingCounter+=1
		learningRate = learningRate * decay
		timesDone += 1

	while (testingCounter < holdOutNumber):
		err = HFunction(trainingCounter+testingCounter)-float(output[trainingCounter+testingCounter])
		testingCounter+=1
		errorList.append(err)

	for value in errorList:
		if value == 0:
			zeroCount+=1
	zeroCount = (zeroCount/(len(errorList))*100)

	#print (outputWeight)
	print("There are ", zeroCount, " percent correct")
