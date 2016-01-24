
public class BoardState {
	public static int[][] board = new int[7][6];
	public static int [][] possibleBoard = board;
	
	public static void makeBoard(int width, int height)
	{
		board = new int[width][height];
		for(int i =0; i< width;i++)
		{
			for(int j=0;j<height;j++)
			{
				board[i][j]=99;
				System.out.printf("%5d",board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void makeMove(Move move, Boolean isFinal)
	{
		Loop.numTurns++;
		//if isFinal set actual board, else set possible board to use for searching
		//set board to have a 0 or 1 dependent in the bottommost empty row in the column
		
		//Keeping track of board and moves
		if(isFinal)
		{
			for(int i=move.column;i<=move.column;i++)
			{
				for(int j=0;j<=SamplePlayer.height;j++)
				{
					if(board[j][i]==99)
					{
						if(move.player==0){
							board[j][i]=0;
							break;
						}
						else
						{
							board[j][i]=1;
						}
					}
				}	
			}

			
			for(int i=SamplePlayer.width-1;i>=0;i--)
			{
				for(int j=0;j<SamplePlayer.height;j++)
				{
					System.out.printf("%5d",board[i][j]);
				}
				System.out.println();
			}
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
