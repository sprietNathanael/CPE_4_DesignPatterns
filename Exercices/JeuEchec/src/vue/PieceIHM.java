/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import model.Couleur;
import model.pieces.Pieces;

/**
 *
 * @author nathanael
 */
public class PieceIHM implements PieceIHMs{
    private Pieces piece;

    public PieceIHM(Pieces piece) {
        this.piece = piece;
    }

    @Override
    public int getX() {
        return this.piece.getX();
    }

    @Override
    public int getY() {
        return this.piece.getY();
    }

    @Override
    public Couleur getCouleur() {
        return this.piece.getCouleur();
    }

    @Override
    public String getName() {
        return this.piece.getName();
    }

    @Override
    public String toString() {
        return ""+this.getName()+" "+this.getCouleur()+" : "+this.getX()+";"+this.getY();
    }
    
    
    
}
