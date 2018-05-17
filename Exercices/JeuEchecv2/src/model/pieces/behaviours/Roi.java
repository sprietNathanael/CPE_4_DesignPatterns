package model.pieces.behaviours;

import model.Coord;
import model.Couleur;
import model.pieces.Piece;
import model.pieces.Piece;


/**
 * @author francoise.perrin
 * * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 */
public final class Roi implements Behaviours {
    
    
    private static Behaviours thisBehaviour;
    
    private Roi(){
    }    
    
    public static Behaviours getInstance() {
        if(thisBehaviour == null)
        {
            thisBehaviour = new Roi();
        }
        return thisBehaviour;
    }
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible, boolean premierCoup) {
		boolean ret = false;
		
		if ((Math.abs(yFinal - yInit) <= 1)
				&& (Math.abs(xFinal - xInit) <= 1)) {
			ret = true;
		}
		
		
		return ret;
	}

	

	
}
