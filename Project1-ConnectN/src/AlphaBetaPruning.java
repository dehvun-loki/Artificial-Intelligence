
public class AlphaBetaPruning {

	public static Move move(Move state) {
	    Move bestMove = null;
	    int bestScore = -10000;
	    Move gameTreeRoot = state;
	    int maxDepth = 1;
		while (true)
		{
			for(int i=0;i<=maxDepth;i++)
			{
				for (Object child : Loop.FindLegalMove())
				{
					int alpha = miniMax((Move)child, maxDepth, bestScore, 10000);
					if (alpha > bestScore || bestMove == null) 
					{
						bestMove = (Move)child;
						bestScore = alpha;
					}
				}
				return bestMove;
			}
			maxDepth++;
		}				
	}
	
	public static int miniMax(Move move, int depth, int alpha, int beta) {
		// TODO Auto-generated method stub
		if(depth<=0)
		{
			return Heuristic.evaluate(move);
		}
	    if (Loop.lastMove.player==1) {
	        int currentAlpha = -10000;
	        for (Object child : Loop.FindLegalMove()) {
	        	child = new Move((int)child, currentAlpha, currentAlpha);
	            currentAlpha = Math.max(currentAlpha, miniMax((Move)child, depth - 1, alpha, beta));
	            alpha = Math.max(alpha, currentAlpha);
	            if (alpha >= beta) {
	                return alpha;
	            }
	        }
	        return currentAlpha;
	    }
	    int currentBeta = 10000;
	    for (Object child : Loop.FindLegalMove()) {
	    	currentBeta = Math.min(currentBeta, miniMax((Move)child, depth - 1, alpha, beta));
	        beta = Math.min(beta, currentBeta);
	        if (beta <= alpha) {
	        	return beta;
	        }
	    }
	    return currentBeta;

		
	}

}
