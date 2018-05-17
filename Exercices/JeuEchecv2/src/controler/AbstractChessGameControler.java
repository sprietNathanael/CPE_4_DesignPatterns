/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.List;
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
        return (this.game.getColorCurrentPlayer() == this.game.getPieceColor(initCoord.x, initCoord.y));
    }

    @Override
    public String toString() {
        return "AbstractChessGameControler{" + "game=" + game + '}';
    }
    
    public List<Coord> getAllPossiblePlacements(Coord coords){
        List<Coord> res = new ArrayList<Coord>();
        for (int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++){
                if(this.game.isMoveOk(coords.x, coords.y, col, row)){
                    res.add(new Coord(col,row));
                }
            }            
        }
        return res;
    }
    
    
}
