import java.io.*;

import java.util.*;

//****I think I made this class wrong. I'm like 98% sure I needed to include interfaces 
//but I forgot what those were when I made it and didn't add them. Now what? SOS.


public class Loop {
	//Look at the board
	public int GetBoard(){
		//I wanted to have a statement to determine whether the move was the first
		//if first move, generate first board; else take last generated board plus most recent move
		//This way eliminates any need to pull the board from the interface
		//Would still need to pull opponent's move (I think)
		return 0;
	}
	
	//Find the legal moves
	public int FindLegalMove(){
		
		int board;
		//Guessing this is the way to declare a variable holding an array of arrays of ints?
		board = GetBoard();

		
		//Alpha Beta to find moves
		//*****AlphaBetaPruning.getMove(height, width, numToWin, move, board);*****
		//where should all these variables be defined?
		//Are we even using samplePlayer now that we have this class?
		
		return 0;
	}
	//Find Value of moves
	public int EvaluateMove(){	
		int currentMove;
		int moveValue = 0;
		
		LinkedList valueList = new LinkedList();
		//There's a way to resolve the "raw" warning with pointy brackets but I gave up
		
		//if FindLegalMove != null
			currentMove = FindLegalMove();
			
			//******moveValue = Heuristic.evaluate(currentMove);*****
			//This needs to be linked to the Heuristic class...see my above SOS.
			
			
			//Store value in list
			valueList.add(moveValue);
			
		//else
			//Find max of list
			FindMax(valueList);
		
		return 0;
	}

	public int FindMax(LinkedList list){
		int currentMax = 0;
		int currentValue;
		for (int i=0; i<list.size(); i++){
			currentValue = (int) list.get(i);
			
			if (currentValue > currentMax){
				currentMax = currentValue;	
			} 	
		}
		
		return currentMax;
	}
	
		
}