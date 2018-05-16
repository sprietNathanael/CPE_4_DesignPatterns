package vue;

import model.Coord;
import controler.AbstractChessGameControler;
import controler.ChessGameControlers;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import model.Couleur;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 * Vue console d'un jeu d'échec
 * Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 */
public class ChessGameCmdLine extends AbstractGameView {


	public   ChessGameCmdLine(ChessGameControlers chessGameControler) {
            super(chessGameControler);
	}


	public void go() {

		System.out.print("\n Déplacement de 3,6 vers 3,4 = ");
		chessGameControler.move(new Coord(3,6), new Coord(3, 4));	// true
		
		System.out.print("\n Déplacement de 3,4 vers 3,6 = \n");		
		chessGameControler.move(new Coord(3,4), new Coord(3, 6));	// false 
		
		System.out.print("\n Déplacement de 4,1 vers 4,3 = \n");
		chessGameControler.move(new Coord(4, 1), new Coord(4, 3));	// true
		
		System.out.print("\n Déplacement de 3,4 vers 3,4 = \n");
		chessGameControler.move(new Coord(3, 4), new Coord(3, 4));	// false
		
		System.out.print("\n Déplacement de 3,4 vers 4,3 = \n");
		chessGameControler.move(new Coord(3, 4), new Coord(4, 3));	// true		
	}
        
    public void updatePiecesIHM(List<PieceIHMs> piecesIHM)
    {
        System.out.println(chessGameControler.getMessage() + "\n");	
        String[][] damier = new String[8][8];
        
        for (Iterator<PieceIHMs> iter = piecesIHM.listIterator(); iter.hasNext(); ) {
            PieceIHMs pieceIHM = iter.next();
            Couleur color = pieceIHM.getCouleur();
            String stColor = (Couleur.BLANC == color ? "B_" : "N_");

            String type = (pieceIHM.getName()).substring(0, 2);
            if(pieceIHM.getX() > -1 && pieceIHM.getY() > -1)
            {
                damier[pieceIHM.getY()][pieceIHM.getX()] = stColor + type;
            }
        }
		
        // Affichage du tableau formatté
        String st = "    0     1     2     3     4     5    6     7 \n";
        for ( int i = 0; i < 8; i++) {
                st += i + " ";
                for ( int j = 0; j < 8; j++) {				 
                        String nomPiece = damier[i][j];				
                        if (nomPiece != null) {						
                                st += nomPiece + "\u001B[0m  ";
                        } 
                        else {
                                st += "____  ";
                        }
                }
                st +="\n";
        }
		
        System.out.println(st);
    }
    
}
