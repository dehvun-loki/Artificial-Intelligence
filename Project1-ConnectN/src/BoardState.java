
public class BoardState {
	public static int[][] board = new int[7][6];
	
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
	
	
}
