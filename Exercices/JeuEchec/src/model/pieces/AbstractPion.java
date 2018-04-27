package model.pieces;

import model.Coord;
import model.Couleur;
import model.pieces.AbstractPiece;




/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
public abstract class AbstractPion extends AbstractPiece  {

	private boolean premierCoup;

	/**
	 * @param name
	 * @param couleur_de_piece
	 * @param coord
	 */
	public AbstractPion(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
		this.premierCoup = true;
	}
        
        protected abstract boolean deplacementDiagonal(int xFinal, int yFinal);
        protected abstract boolean deplacementVertical(int xFinal, int yFinal);

	/* (non-Javadoc)
	 * @see model.AbstractPiece#isMoveOk(int, int)
	 */
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {

		boolean ret = false;

		// Déplacement vertical
		if (!isCatchOk && !isCastlingPossible){

			if ((xFinal == this.getX())
					&& (Math.abs(yFinal - this.getY()) <= 1 || 
					(Math.abs(yFinal - this.getY()) <= 2 && this.premierCoup==true))) {
                            this.deplacementVertical(xFinal, yFinal);
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
                    ret = this.deplacementDiagonal(xFinal, yFinal);
                    
		}

		return ret;
	}



	/* (non-Javadoc)
	 * @see model.AbstractPiece#move(int, int)
	 */
	@Override
	public boolean move(int x, int y){

		boolean ret = false;

		if(Coord.coordonnees_valides(x,y)){
			this.premierCoup = false;
			ret = super.move(x, y);
		}
		return ret;
	}



}
