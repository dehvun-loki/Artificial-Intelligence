
public class Evaluations {
	public static int checkMaxChain(int move)
	{
		return 0;//TODO return max chain length using move
	}
	public static int checkMaxPossibleChain(int move, int direction)
	{
		int state = 0, currentColumn = 0, currentRow = 0;
		int value[][] = BoardState.board;
		
		for(int i=0; i<(Loop.height-1);i++){
			if (value[i][move] == 99){
				currentColumn = move; //Making a less confusing variable name
				currentRow = i; //Making a less confusing variable name
			}
			int nonEnemyChain; //Keeps track of the length of the chain that currently exists
			int counter; //This is the counter that is used for all the for loops
			
			//find direction of chain
			switch (state){
			case 0: //Vertical Chain
				int chainSoFar = 0; //No chain yet
				counter = 0; //Start counting at zero
				int verticalSpaceLeft = Loop.height - currentRow; //The amount of space left is equal to the total height minus the row we are on
				
				if (value[currentRow-1][currentColumn] == 0){//If the space under us is also us:
					for(counter = currentRow; counter>=1; counter--){ 
						//Checking for more of our pieces in this column in each space under us
						if (value[counter][currentColumn] == 0){ //If our piece is in the row under the last checked row
							chainSoFar++; //Increment the chain variable
						}
						else{
							//If we find a piece somewhere in the column that is an opponent
							//make the counter be something beyond the bounds of the for loop
							//This breaks the for loop and stops counting the chain..
							counter = 0;
						}
					}
				}
				if ((verticalSpaceLeft + chainSoFar) > Loop.numToWin){
					//If the sum of the space left plus the existing chain is greater than the number required to win
					//still possible to win. Return accordingly.
				}
				else {
					break;
				}				
			case 1:
				//Horizontal Chain
				nonEnemyChain = 0; //No chain yet
				counter = 0; //Start counting at zero
				int spaceToLeft = 0;
				int spaceToRight = 0;
				
				if (value[currentRow][currentColumn-1] == 0){ //If the value to the left of where we are is our piece
					for(counter = currentColumn; counter>=0; counter--){
						if ((value[currentRow][counter] == 0) | (value[currentRow][counter]==99)){
							//If the space is either empty or is friendly
							nonEnemyChain++; //Chain of our moves plus possible moves
						}
						else{
							counter = -1;
						}
					}
				}				
				
				if (nonEnemyChain < Loop.numToWin){
					//still possible to win. Return accordingly.
				}
				else {
					break;
				}				
				break;
			case 2:
				//Diagonal Right Chain
				break;
			case 3:
				//Diagonal Left Chain
				break;
			case 4:
				//Don't know if I'll use this
				break;
			}
			//find length of chain so far
			//find length still possible to go in that direction
			
			
			
		}
		return 0; //TODO return max chain length that can be achieved in 
				  //this location without worrying about if opponent can block
	}
}
