/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tools.CustomObserver;

/**
 *
 * @author nathanael
 */
public abstract class AbstractGameView implements GameViews, CustomObserver{
    
    protected ChessGameControlers chessGameControler;

    public AbstractGameView(ChessGameControlers controller) {
        this.chessGameControler = controller;
    }
    
    @Override
    public final void update(Object arg) {
        List<PieceIHMs> piecesIHM = (List<PieceIHMs>)arg;
        this.updatePiecesIHM(piecesIHM);
        
    }

    public abstract void updatePiecesIHM(List<PieceIHMs> piecesIHMs);
}
