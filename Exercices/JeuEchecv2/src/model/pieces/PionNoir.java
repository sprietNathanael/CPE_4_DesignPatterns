/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pieces;

import model.Coord;
import model.Couleur;

/**
 *
 * @author nathanael
 */
public class PionNoir extends AbstractPion
{

    public PionNoir(Couleur couleur_de_piece, Coord coord) {
        super(couleur_de_piece, coord);
    }

    @Override
    protected boolean deplacementDiagonal(int xFinal, int yFinal) {
        if ((yFinal == this.getY()+1 && xFinal == this.getX()+1) 
                                         || (yFinal == this.getY()+1 && xFinal == this.getX()-1)) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean deplacementVertical(int xFinal, int yFinal) {
        if(yFinal - this.getY() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
    
}
