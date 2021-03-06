package model.pieces;

import java.util.HashMap;
import java.util.Map;
import model.Coord;
import model.Couleur;
import model.pieces.behaviours.Behaviours;
import model.pieces.behaviours.Tour;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * G�re le comportement commun � toutes les pi�ces
 * Chaque classe d�riv�e (Pion, etc.) sera capable de dire 
 * si le d�placement est OK.
 */
import tools.BehaviourFactories;
public class Piece implements Pieces {

	private int x, y;
	private Couleur couleur;
        private Behaviours behaviour;
        private final Behaviours initialBehaviour;
        private BehaviourFactories behaviourFactory;
        private boolean premierCoup;
        /*private static final Map<Integer, Behaviours> behavioursByColumn = new HashMap<>();
        static {
            behavioursByColumn.put(0, Tour);
            behavioursByColumn.put(7, "two");
        }*/
	

	/**
	 * @param name
	 * @param couleur
         * @param behaviour
	 * @param coord
	 */
	public Piece(Couleur couleur, Coord coord, String classname, BehaviourFactories behaviourFactory){
		this.x = coord.x;
		this.y = coord.y;
		this.couleur=couleur;
                this.behaviour = behaviour;
                this.initialBehaviour = behaviourFactory.buildBehaviour(classname);
                this.premierCoup = true;
                this.behaviourFactory = behaviourFactory;
                this.updateBehaviour();
	}

	/* (non-Javadoc)
	 * @see model.Pieces#getX()
	 */
	public int getX(){
		return this.x;
	}

	/* (non-Javadoc)
	 * @see model.Pieces#getY()
	 */
	public int getY(){
		return this.y;
	}

	/* (non-Javadoc)
	 * @see model.Pieces#getCouleur()
	 */
	public Couleur getCouleur(){
		return this.couleur;
	}

	/* (non-Javadoc)
	 * @see model.piece.Pieces#getType()
	 */
	public String getName() {
		return this.initialBehaviour.getClass().getSimpleName();
	}
	
	/* (non-Javadoc)
	 * @see model.Pieces#move(int, int)
	 * 
	 * Déplace une pièce
	 */
	public boolean move(int x, int y){
		boolean ret = false;
		if(Coord.coordonnees_valides(x,y)){
			this.x=x;
			this.y=y;
			ret = true;
                        this.premierCoup = false;
		}
                this.updateBehaviour();                
		return ret;

	}
        
        private void updateBehaviour()
        {
            this.behaviour = this.behaviourFactory.getBehaviour(this.x,this.y,this.initialBehaviour);
        }
	
	/* (non-Javadoc)
	 * @see model.Pieces#capture()
	 * 
	 * Capture une piece : 
	 * passer ses coordonn�es � -1
	 */
	public boolean capture(){
		this.x=-1;
		this.y=-1;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString(){	
		String S = (this.getName()).substring(0, 2) 
				+ " " + this.x + " " + this.y;
		
		return S;
	}


	/* (non-Javadoc)
	 * @see model.Pieces#isMoveOk(int, int)
	 * 
	 * En fonction du type de pièce (Pion, etc.)
	 * est capable de dire si le déplacement est OK
	 */
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible)
        {
            return(this.behaviour.isMoveOk(this.x, this.y, xFinal, yFinal, isCatchOk, isCastlingPossible, this.premierCoup));
        }

}

