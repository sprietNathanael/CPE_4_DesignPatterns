/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import model.Coord;
import model.Couleur;
import tools.CustomObservable;
import tools.CustomObserver;

/**
 *
 * @author nathanael
 */
public class ChessGame extends CustomObservable implements BoardGames{

    private Echiquier echiquier;
    
    public ChessGame() {
        echiquier = new Echiquier();
    }
    
    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        boolean returnValue = false;
        if(this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal))
        {
            if(this.echiquier.move(xInit, yInit, xFinal, yFinal))
            {
                this.echiquier.switchJoueur();
                returnValue = true;
            }
        }
        this.notifyObservers();
        return returnValue;
    }
    
    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal)
    {
        return this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal);
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

    @Override
    public void notifyObservers() {
        for(CustomObserver observer : observers)
        {
            observer.update(this.echiquier.getPiecesIHM());
            
        }
    }
    
    
    
    
}
