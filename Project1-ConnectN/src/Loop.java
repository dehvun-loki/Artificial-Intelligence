import java.io.*;

import java.util.*;



public class Loop {
	public static int width, height, numToWin, playerNumber, timeLimit, moveColumnNumber, currentTurn, numTurns;
	public static Move lastMove;
	
	
	public static void main(String args[]) throws Exception{
		System.out.println("inside Main");
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
        
        numTurns = 0;
        
        BoardState.makeBoard(height,width);
        System.out.println();

		while(true){
			int myTurn = 0;
			
			if (currentTurn == myTurn) {
                // TODO: use a mechanism for timeout(threads, java.util.Timer, ..)
				
                // call alpha-beta algorithm to get the move
                moveColumnNumber = AlphaBetaPruning.move(lastMove).column;
                Move.makeMove(moveColumnNumber);
                BoardState.makeMove(lastMove, true);

                // send move
                System.out.println();
                System.out.println("my move is");
                System.out.println(String.valueOf(moveColumnNumber));
                
                System.out.flush();
            } else {
                // read move
            	System.out.println("your move");
                moveColumnNumber = Integer.parseInt(input.readLine());
                Move.makeMove(moveColumnNumber);
                BoardState.makeMove(lastMove, true);

                // check for end
                if (moveColumnNumber < 0)
                    break;
            }

            // switch turns
            currentTurn = 1 - currentTurn;
            numTurns++;
		}
	}

	//Find the legal moves
	public static LinkedList FindLegalMove(){
		
		LinkedList Rows = new LinkedList();
		LinkedList valueList = new LinkedList();
		int returnedValue = 0;
	
		//Guessing this is the way to declare a variable holding an array of arrays of ints?
		for(int i=0;i<=width-1;i++){
			if(BoardState.board[height-1][i]==99){
				Rows.add(i);
			}
		}
		return Rows;
		/*
		 for (int j=0; j<=(Rows.size()); j++){
		 
			//Run heuristic and get value for playing in that row
			Move nextMove = new Move((int) Rows.get(j),j,0);
			returnedValue = Heuristic.evaluate(nextMove);
			
			//Store heuristic value for row in list
			valueList.add(returnedValue);
		}
		
		FindMax(valueList);
		*/
		//return or print rows?

		//Alpha Beta to find moves
		//AlphaBetaPruning.getMove(height, width, numToWin, move, BoardState.board);
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
	
	public static boolean DetermineTurn(){
		int playerTurn = 0;
		
		if ((numTurns % 2) == 0){
			playerTurn = 1;
		}
		else if ((numTurns % 2) == 1){
			playerTurn = 2;
		}
		
		if (playerNumber == playerTurn){
			return true;
		}
		else {
			return false;
		}	
		
	}

    public static void timer(String... args) throws InterruptedException {
        double startTime = System.nanoTime();

        double difference = System.nanoTime() - startTime;
        if (difference >= 1000000000){
        	//force best available move
        }
    }
	
}
	
	