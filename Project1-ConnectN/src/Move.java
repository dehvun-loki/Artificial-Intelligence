
public class Move {
	public int column;
	public int row;
	public int player;
	
	public Move(int a, int b, int c)
	{
		column=a;
		row=b;
		player=c;		
	}
	
	public static void makeMove(int moveColumn)
	{
		for(int i=moveColumn;i<=moveColumn;i++)
		{
			for(int j=0;j<=SamplePlayer.height;j++)
			{
				if(BoardState.board[j][i]==99)
				{
					Loop.lastMove=new Move(moveColumn,j,1);
				}
			}	
		}

	}
}
