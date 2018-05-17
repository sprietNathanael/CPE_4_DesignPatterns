/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pieces.behaviours;

import model.Coord;
import model.Couleur;

/**
 *
 * @author nathanael
 */
public final class PionBlanc extends AbstractPion
{
    
    
    private static Behaviours thisBehaviour;
    
    private PionBlanc(){
    }    
    
    public static Behaviours getInstance() {
        if(thisBehaviour == null)
        {
            thisBehaviour = new PionBlanc();
        }
        return thisBehaviour;
    }

    @Override
    protected boolean deplacementDiagonal(int xInit, int yInit, int xFinal, int yFinal) {
        if ((yFinal == yInit-1 && xFinal == xInit+1) 
						|| (yFinal == yInit-1 && xFinal == xInit-1)) {
            return(true);
        }
        return false;
    }

    @Override
    protected boolean deplacementVertical(int xInit, int yInit, int xFinal, int yFinal) {
        if(yFinal - yInit < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    
    
}
