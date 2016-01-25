
public class BoardState {
	public static int[][] board = new int[6][7];
	public static int [][] possibleBoard = board;
	
	public static void makeBoard(int height, int width)
	{
		board = new int[height][width];
		for(int i =0; i< height;i++)
		{
			for(int j=0;j<width;j++)
			{
				board[i][j]=99;
				System.out.printf("%5d",board[i][j]);
			}
			System.out.println();
		}
		possibleBoard = board;
		
	}
	
	public static void makeMove(Move move, Boolean isFinal)
	{


		//if isFinal set actual board, else set possible board to use for searching
		//set board to have a 0 or 1 dependent in the bottommost empty row in the column
		
		//Keeping track of board and moves
		if(isFinal)
		{
			for(int j=0;j<=Loop.height-1;j++)
			{
				if(board[j][move.column]==99)
				{
					if(move.player==0){
						board[j][move.column]=0;
						break;
					}
					else
					{
						board[j][move.column]=1;
						break;
					}
				}
			}	
		}


		if(isFinal){
			for(int i =Loop.height-1; i>=0;i--)
			{
				for(int j=0;j<Loop.width;j++)
				{
					System.out.printf("%5d",board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			possibleBoard = board;
		}
		
		else
		{
			if(possibleBoard[move.column][move.row]==99)
				{
				if(move.player==0){
					possibleBoard[move.column][move.row]=0;
				}
				else
				{
					possibleBoard[move.column][move.row]=1;
				}
			}
		}
		
		
		
	}
	public static void deleteMove(Move move, Boolean isFinal)
	{
		if(isFinal)
		{
			board[move.column][move.row]=99;	
		//remove topmost filled space in the column specified
		}
		else possibleBoard[move.column][move.row]=99;
	}
}
