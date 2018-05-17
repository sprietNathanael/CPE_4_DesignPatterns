package tools;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Coord;
import model.Couleur;
import model.pieces.Piece;
import model.pieces.Pieces;
import model.pieces.behaviours.Behaviours;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * 
 * Classe qui fabrique une liste de pieces de jeu d'echec
 * de la couleur pass�e en param�tre
 *
 */
public class ChessPiecesFactory {

	/**
	 * private pour ne pas instancier d'objets
	 */
	private ChessPiecesFactory() {

	}

	/**
	 * @param pieceCouleur
	 * @return liste de pi�ces de jeu d'�chec
	 */
	public static List<Pieces> newPieces(Couleur pieceCouleur){

		List<Pieces> pieces = null;
		pieces = new LinkedList<Pieces>();
		
		if (pieceCouleur != null){
			for (int i = 0; i < ChessPiecePos.values().length; i++) {

				if (pieceCouleur.equals(ChessPiecePos.values()[i].couleur)) {
					for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
						String className = "model.pieces.behaviours." + ChessPiecePos.values()[i].nom;	// attention au chemin
						Coord pieceCoord = ChessPiecePos.values()[i].coords[j];
                                            try {
                                                //pieces.add((Pieces) Introspection.newInstance (className, new Object[] {pieceCouleur, pieceCoord}));
                                                Behaviours behaviour = (Behaviours)Class.forName(className).getMethod("getInstance", null).invoke(null, null);
                                                //pieces.add((Pieces) Introspection.newInstance("model.pieces.Piece", new Object[] {pieceCouleur, pieceCoord, behaviour}));
                                                pieces.add((Pieces) new Piece(pieceCouleur, pieceCoord, behaviour, TempeteBehaviourFactory.getInstance()));
                                            } catch (ClassNotFoundException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (NoSuchMethodException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (SecurityException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (IllegalAccessException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (IllegalArgumentException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (InvocationTargetException ex) {
                                                Logger.getLogger(ChessPiecesFactory.class.getName()).log(Level.SEVERE, null, ex);
                                            }
					}
				}
			}
		}
		return pieces;
	}

	/**
	 * Tests unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessPiecesFactory.newPieces(Couleur.BLANC));
		System.out.println(ChessPiecesFactory.newPieces(Couleur.NOIR));
	}
}
