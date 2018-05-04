/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlers;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author nathanael
 */
public class AbstractGameView implements GameViews, Observer{
    
    protected ChessGameControlers chessGameControler;

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AbstractGameView(ChessGameControlers controller) {
        this.chessGameControler = controller;
    }
    
}
