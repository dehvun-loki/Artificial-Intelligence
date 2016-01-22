import java.io.*;

import java.util.*;



public class Loop {
	public static int width, height, numToWin, playerNumber, timeLimit, move, currentTurn;
	
	
	public static void main() throws Exception{
        // use BufferedReader for easy reading
        BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in));

        // send player name
        System.out.println("random-player");
        //System.out.flush();

        // read game config
        String [] gameConfig = input.readLine().split(" ");
        height = Integer.parseInt(gameConfig[0]);
        width = Integer.parseInt(gameConfig[1]);
        numToWin = Integer.parseInt(gameConfig[2]);
        playerNumber = Integer.parseInt(gameConfig[3]);
        timeLimit = Integer.parseInt(gameConfig[4]);
        
        BoardState.makeBoard(width,height);

		while(true){
			int myTurn = 0;
			
			if (currentTurn == myTurn) {
                // TODO: use a mechanism for timeout(threads, java.util.Timer, ..)
				
                // call alpha-beta algorithm to get the move
                move = AlphaBetaPruning.getMove(height, width, numToWin, move, BoardState.board);

                // send move
                System.out.println(String.valueOf(move));
                System.out.flush();
            } else {
                // read move
                move = Integer.parseInt(input.readLine());
                BoardState.makeMove(move, true);

                // check for end
                if (move < 0)
                    break;
            }

            // switch turns
            currentTurn = 1 - currentTurn;
		}
	}

	//Find the legal moves
	public int FindLegalMove(){
	
		//Guessing this is the way to declare a variable holding an array of arrays of ints?

		//Alpha Beta to find moves
		AlphaBetaPruning.getMove(height, width, numToWin, move, BoardState.board);
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
			moveValue = Heuristic.evaluate(currentMove);
			
			
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
