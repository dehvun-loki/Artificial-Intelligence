
public class Heuristic {
	
	public static int evaluate(Move move)
	{

		if(winningMove(move))//checks for a winning move for either player
		{
			if(Loop.DetermineTurn())//check whose turn it is TODO 
			{
				return 10; // if this players turn program wins
			}
			else return 0; // else other player wins
		}
		else if(stillPossibleToWin(move))
		{
			BoardState.makeMove(move, false);
			return furtherEvaluate(move);
		}
		else //this means that it is not a winning or losing move, 
			 //but it is not possible to win from here, so it might as well be losing
			return 0;
		
		
	}
	
	
	public static Boolean winningMove(Move move)
	{
		if(Evaluations.checkMaxChain(move)>=Loop.numToWin)
		{
			return true;
		}
		else return false;
		
	}
	
	
	public static Boolean stillPossibleToWin(Move move)
	{	
		//TODO needs to return an int
		return Evaluations.checkMaxPossibleChain(move)>=Loop.numToWin;	
	}

	public static int furtherEvaluate(Move move)
	{	
		//If....
		//On Edge
		//Adding to chain
		//
		return 0;
	}
}
		

