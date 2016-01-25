
public class Evaluations {
	public static int checkMaxChain(Move move)
	{
		return 0;//TODO return max chain length using move
	}

	public static int checkMaxPossibleChain(Move move){
		int state = 0, currentColumn = 0, currentRow = 0;
		int value[][] = BoardState.possibleBoard;
		int longestChain0 = 0,longestChain1 = 0,longestChain2 = 0,longestChain3 = 0; 

		currentColumn = move.column;
		currentRow = move.row;
			
			int nonEnemyChain; //Keeps track of the length of the chain that currently exists
			int counter; //This is the counter that is used for all the for loops
			int myChain;
			int longestChain;
			//find direction of chain
			switch (state){
			case 0: //Vertical Chain
				//int chainSoFar = 0; //No chain yet
				longestChain=0;
				counter = 0; //Start counting at zero
				int verticalSpaceLeft = Loop.height - currentRow; //The amount of space left is equal to the total height minus the row we are on
				if (currentRow == 0 || currentRow == Loop.height-1){
					for(counter = currentRow; counter>=1; counter--){ 
						//Checking for more of our pieces in this column in each space under us
						if (value[counter][currentColumn] == 0){ //If our piece is in the row under the last checked row
							longestChain++; //Increment the chain variable
						}
						else{
							//If we find a piece somewhere in the column that is an opponent
							//make the counter be something beyond the bounds of the for loop
							//This breaks the for loop and stops counting the chain..
							counter = 0;
						}
					}

				}
				else{
					if (value[currentRow-1][currentColumn] == 0){//If the space under us is also us:
						for(counter = currentRow; counter>=1; counter--){ 
							//Checking for more of our pieces in this column in each space under us
							if (value[counter][currentColumn] == 0){ //If our piece is in the row under the last checked row
								longestChain++; //Increment the chain variable
							}
							else{
								//If we find a piece somewhere in the column that is an opponent
								//make the counter be something beyond the bounds of the for loop
								//This breaks the for loop and stops counting the chain..
								counter = 0;
							}
						}
					}
				}
				
				if (longestChain >= Loop.numToWin){
					longestChain0 = longestChain;
				}
				
				else if ((verticalSpaceLeft + longestChain) >= Loop.numToWin){
					//If the sum of the space left plus the existing chain is greater than the number required to win
					//still possible to win. Return accordingly.
					longestChain0 = verticalSpaceLeft + longestChain;
				}
				else {
					break;
				}				
			case 1:
				//Horizontal Chain
				nonEnemyChain = 0; //No chain yet
				myChain = 0;
				counter = 0; //Start counting at zero
				longestChain = 0;
				
				currentRow=Math.min(currentRow, Loop.height-1);
				if ((value[currentRow][Math.max(currentColumn-1,0)] == 0)||(value[currentRow][Math.min(currentColumn+1,Loop.width-1)] == 0)){ //If the value to the left of where we are is our piece
					
					for(counter = Math.min(currentColumn+Loop.numToWin-1,Loop.width-1); counter>=0; counter--){
						if (value[currentRow][counter] == 0){
							//If the space is either empty or is friendly
							myChain++;
							nonEnemyChain++; //Chain of our moves plus possible moves
						}
						else if(value[currentRow][counter]==99){
							nonEnemyChain++;
							if (myChain > longestChain){
								longestChain = myChain;
							}
							myChain = 0;
						}
						else if ((value[currentRow][counter]== 1) & (Loop.width-counter-1 >= Loop.numToWin)){
							nonEnemyChain = 0;
							myChain = 0;
							longestChain = 0;
						}
						else {
							counter = -1;
						}
					}
				}
			
				
				if (myChain > longestChain){
					longestChain = myChain;
				}
				
				else if (longestChain >=Loop.numToWin){
					longestChain1 = longestChain;
				}
				else if (nonEnemyChain >= Loop.numToWin){
					//still possible to win. Return accordingly.
					longestChain1 = nonEnemyChain;
				}

				else{
					break;
				}
			case 2:
				//Diagonal Right Chain
				nonEnemyChain = 0; //No chain yet
				counter = 0; //Start counting at zero
				myChain = 0;
				longestChain = 0;
				
				if ((value[Math.max(currentRow-1,0)][Math.max(currentColumn-1,0)] == 0)||(value[Math.min(currentRow+1,Loop.height-1)][Math.min(currentColumn+1,Loop.width-1)] == 0)){ //If the value to the left of where we are is our piece
					int workingRow = currentRow+Loop.numToWin-1;
					
					for(counter=Math.min(currentColumn+Loop.numToWin-1,Loop.width-1); counter<Math.max(currentColumn-Loop.numToWin+1,0); counter--){
						if (workingRow != 0 || workingRow != Loop.height-1 || counter != 0 || counter != Loop.width-1){
							if (value[workingRow][counter] == 0){
								//If the space is either empty or is friendly
								myChain++;
								nonEnemyChain++; //Chain of our moves plus possible moves
							}
							else if (value[workingRow][counter]==99){
								nonEnemyChain++;
								if (myChain > longestChain){
									longestChain = myChain;
								}
							}
							else if ((value[workingRow][counter]==1)&(Loop.width-counter-1 >= Loop.numToWin)&(Loop.height-workingRow >= Loop.numToWin)){
								nonEnemyChain = 0;
								myChain = 0;
								longestChain = 0;
							}
							else {
								counter = -1;
							}
						}
						else{
							//skip this
						}
						workingRow--;
				}
			}
				
				if (myChain > longestChain){
					longestChain = myChain;
				}
				
				if (longestChain >= Loop.numToWin){
					longestChain2 = longestChain;
				}
				else if (nonEnemyChain <= Loop.numToWin){
					//still possible to win. Return accordingly.
					longestChain2 = longestChain;
				}
				else {
					break;
				}
				
			case 3:
				//Diagonal Left Chain
				nonEnemyChain = 0; //No chain yet
				counter = 0; //Start counting at zero
				myChain = 0;
				longestChain = 0;

				if ((value[Math.min(currentRow+1,Loop.height-1)][Math.min(currentColumn+1,Loop.width-1)] == 0)||(value[Math.max(currentRow-1,0)][Math.max(currentColumn-1,0)] == 0)){ //If the value to the left of where we are is our piece
					int workingRow = Math.min(currentRow+Loop.numToWin-1,Loop.height-1);
					
					for(counter=Math.max(currentColumn-Loop.numToWin+1,0); counter<Math.min(currentColumn+Loop.numToWin-1,Loop.width-1)-1; counter++){
						if (workingRow >= 0 || workingRow <= Loop.height-1 || counter != 0 || counter != Loop.width-1){
							if ((value[Math.min(workingRow,Loop.height-1)][counter] == 0) || (value[Math.min(workingRow,Loop.height-1)][counter]==99)){
								//If the space is either empty or is friendly
								nonEnemyChain++; //Chain of our moves plus possible moves
							}
							else if (value[workingRow][counter]==99){
								nonEnemyChain++;
								if (myChain > longestChain){
									longestChain = myChain;
								}
							}
							else if ((value[workingRow][counter] == 1)&(Loop.width-counter-1 >= Loop.numToWin)&(Loop.height-workingRow >= Loop.numToWin)){
								nonEnemyChain = 0;
								myChain = 0;
								longestChain = 0;
							}
							else {
								counter = -1;
							}
						}
						else{
							//pass
						}
						workingRow++;
					}
				}
				
				if (myChain > longestChain){
					longestChain = myChain;
				}
				
				if (longestChain >= Loop.numToWin){
					longestChain3 = longestChain;
				}
				else if (nonEnemyChain <= Loop.numToWin){
					//still possible to win. Return accordingly.
					longestChain3 = longestChain;
				}
				else {
					break;
				}
				

			
			}
		//System.out.println(Math.max(Math.max(longestChain0, longestChain1), Math.max(longestChain2, longestChain3)));
		return Math.max(Math.max(longestChain0, longestChain1), Math.max(longestChain2, longestChain3));		  
	}
}
