package model.pieces.behaviours;

import model.Coord;
import model.Couleur;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public final class Cavalier implements Behaviours{
    
    
    private static Behaviours thisBehaviour;
    
    private Cavalier(){
    }    
    
    public static Behaviours getInstance() {
        if(thisBehaviour == null)
        {
            thisBehaviour = new Cavalier();
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
		
		if ((Math.abs(xFinal - xInit) + Math.abs(yFinal - yInit)) == 3) {
			
			if ((Math.abs(xFinal - xInit)<3) && (Math.abs(yFinal - yInit)<3)) {
				ret  = true;
			}		
		}	
		
		return ret;
	}

	

	
}
