
public class Move {
	public int column;
	public int row;
	public int player;
	
	public Move(int a, int b, int c)
	{
		row=a;
		column=b;
		player=c;		
	}
	
	public static Move makeMove(int moveColumn, Boolean inMainLoop)
	{
		if(inMainLoop){
			for(int j=0;j<=Loop.height-1;j++)
			{
				if(BoardState.board[j][moveColumn]==99)
				{
					if(Loop.DetermineTurn())
					{
						Loop.lastMove=new Move(j,moveColumn,1);
						return Loop.lastMove;
					}
					else
					{
						Loop.lastMove=new Move(j,moveColumn,0);
						return Loop.lastMove;
					}
				}
				else{}
			}	
			return new Move(0,0,0);
		}
		else{
			for(int j=0;j<=Loop.height-1;j++)
			{
				if(BoardState.board[j][moveColumn]==99)
				{
					if(Loop.DetermineTurn())
					{
						return new Move(j,moveColumn,1);
					}
					else
					{
						
						return 	new Move(j,moveColumn,0);
					}
				}
				else{}
			}	
			return new Move(0,0,0);
		}
	}
}
