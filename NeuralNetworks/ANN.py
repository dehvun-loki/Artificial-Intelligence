#!/usr/bin/env python 

import math
import random

def FillLists(numHidden):

	test = open("Hello.txt","r")
	
	
	firstInput = []
	secondInput = []
	output = []

	inputWeight1 = []
	inputWeight2 = []
	outputWeight = []


	counter = 1

	for line in test:
		words = line.split()
		#IO = test.read()
		
		firstInput.append(words[0])
		secondInput.append(words[1])
		output.append(words[2])
		
	while(counter<numHidden):
		inputWeight1.append(random.uniform(-1,1))
		inputWeight2.append(random.uniform(-1,1))
		outputWeight.append(random.uniform(-1,1))

		counter+=
		

def HFunction(pointer):
	weightPointer = 0
	y1 = (firstInput[pointer] * inputWeight1[weightPointer])
	y2 = (secondInput[pointer] * inputWeight2[weightPointer])
	y = y1+y2

	mathStuff = outputWeight[weightPointer] * Sigmoid(y)

	#make a list of mathStuffs
	#Add all together
	#Sigmoid of total
	#does it match output[pointer]


def Sigmoid(x):
	sigMath = 1/(1+math.exp(-x))
	return sigMath








if __name__=='__main__':

	pointer = 0
	#Pull from User input
	FillLists(secondInput)


	#put loop here
	HFunction(pointer)

	#back propogation

