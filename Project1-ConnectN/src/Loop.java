import java.io.*;

import java.util.*;



public class Loop {
	public static int width, height, numToWin, playerNumber, timeLimit, move, currentTurn, numTurns;
	
	
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
        
        numTurns = 0;
        
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
	public void FindLegalMove(){
		
		LinkedList Rows = new LinkedList();
		LinkedList valueList = new LinkedList();
		int returnedValue = 0;
	
		//Guessing this is the way to declare a variable holding an array of arrays of ints?
		for(int i=move;i<=move;i++){
			if(BoardState.board[height][i]==99){
				Rows.add(i);
			}
		}
		
		for (int j=0; j<=(Rows.size()); j++){
			//Run heuristic and get value for playing in that row
			returnedValue = Heuristic.evaluate(j);
			
			//Store heuristic value for row in list
			valueList.add(returnedValue);
		}
		
		FindMax(valueList);
		
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

    public static void main(String... args) throws InterruptedException {
        double startTime = System.nanoTime();

        double difference = System.nanoTime() - startTime;
        if (difference >= 1000000000){
        	//force best available move
        }
    }
	
}
	
	