package model.pieces.behaviours;

import model.Coord;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
public abstract class AbstractPion implements Behaviours{

    protected abstract boolean deplacementDiagonal(int xInit, int yInit, int xFinal, int yFinal);
    protected abstract boolean deplacementVertical(int xInit, int yInit, int xFinal, int yFinal);

	/* (non-Javadoc)
	 * @see model.AbstractPiece#isMoveOk(int, int)
	 */
	@Override
	public final boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible, boolean premierCoup) {

		boolean ret = false;

		// Déplacement vertical
		if (!isCatchOk && !isCastlingPossible){

			if ((xFinal == xInit)
					&& (Math.abs(yFinal - yInit) <= 1 || 
					(Math.abs(yFinal - yInit) <= 2 && premierCoup==true))) {
                            ret = this.deplacementVertical(xInit, yInit, xFinal, yFinal);
				/*if ((Couleur.NOIR.equals(this.getCouleur()) && (yFinal - this.getY() > 0))
						|| (Couleur.BLANC.equals(this.getCouleur()) 
								&& (yFinal - this.getY() < 0))) {
					ret = true;
				}*/
			}
		}
		// Déplacement diagonal
		else {
			/*if (Couleur.NOIR.equals(this.getCouleur())) {
				if ((yFinal == this.getY()+1 && xFinal == this.getX()+1) 
						|| (yFinal == this.getY()+1 && xFinal == this.getX()-1)) {
					ret = true;
				}
			}

			if (Couleur.BLANC.equals(this.getCouleur())) {
				if ((yFinal == this.getY()-1 && xFinal == this.getX()+1) 
						|| (yFinal == this.getY()-1 && xFinal == this.getX()-1)) {
					ret = true;
				}
			}	*/
                    ret = this.deplacementDiagonal(xInit, yInit, xFinal, yFinal);
                    
		}

		return ret;
	}



}
