/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import java.util.Observable;
import model.Couleur;

/**
 *
 * @author nathanael
 */
public class ChessGame extends Observable implements BoardGames{

    private Echiquier echiquier;
    
    public ChessGame() {
        echiquier = new Echiquier();
    }
    
    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if(this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal))
        {
            if(this.echiquier.move(xInit, yInit, xFinal, yFinal))
            {
                this.echiquier.switchJoueur();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEnd() {
        return this.echiquier.isEnd();
    }

    @Override
    public String getMessage() {
        return this.echiquier.getMessage();
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return this.echiquier.getColorCurrentPlayer();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return this.echiquier.getPieceColor(x, y);
    }

    @Override
    public String toString() {
        return "ChessGame{" + "echiquier=" + echiquier + "}\n"+this.getMessage();
    }
    
    
    
    
}
