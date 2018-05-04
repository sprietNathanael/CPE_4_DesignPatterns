/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Coord;
import model.game.BoardGames;

/**
 *
 * @author nathanael
 */
public abstract class AbstractChessGameControler implements ChessGameControlers{

    private BoardGames game;

    public AbstractChessGameControler(BoardGames game) {
        this.game = game;
    }
    
    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
        return this.game.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);
    }

    @Override
    public String getMessage() {
        return this.game.getMessage();
    }

    @Override
    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "AbstractChessGameControler{" + "game=" + game + '}';
    }
    
    
}
