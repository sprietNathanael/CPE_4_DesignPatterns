package model.pieces.behaviours;

import model.Coord;
import model.Couleur;
import model.pieces.Piece;
import model.pieces.Piece;


/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public final class Reine implements Behaviours {
	
    
    private static Behaviours thisBehaviour;
    
    private Reine(){
    }    
    
    public static Behaviours getInstance() {
        if(thisBehaviour == null)
        {
            thisBehaviour = new Reine();
        }
        return thisBehaviour;
    }
	/* (non-Javadoc)
	 * @see model.AbstractPiece#isMoveOk(int, int)
	 */
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible, boolean premierCoup) {
		
		boolean ret = false;
		
		if (Math.abs(yFinal - yInit) == Math.abs(xFinal - xInit)
				|| ((yFinal == yInit) || (xFinal == xInit))) {
			ret =  true;
		}
		
		return ret;
	}

}
