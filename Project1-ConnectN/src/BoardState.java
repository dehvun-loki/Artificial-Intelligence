
public class BoardState {
	public static int[][] board = new int[7][6];
	public int [][] possibleBoard = board;
	
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
	
	public static void makeMove(int move, Boolean isFinal)
	{
		//if isFinal set actual board, else set possible board to use for searching
		//set board to have a 0 or 1 dependent in the bottommost empty row in the column
		
	}
	public static void deleteMove(int move)
	{
		//remove topmost filled space in the column specified
	}
}
