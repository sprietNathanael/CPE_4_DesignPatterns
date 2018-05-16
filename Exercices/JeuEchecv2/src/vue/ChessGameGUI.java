/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlers;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author nathanael
 */
public class ChessGameGUI extends AbstractGameView{
    
    private ChessGameWindow window;

    public ChessGameGUI(String name, ChessGameControlers chessGameControler, Dimension boardSize) {
        super(chessGameControler);
        this.window = new ChessGameWindow(name, chessGameControler, boardSize);
        
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setLocation(600, 10);
        this.window.setPreferredSize(boardSize);
        this.window.pack();
        this.window.setVisible(true);
    }

    @Override
    public void updatePiecesIHM(List<PieceIHMs> piecesIHMs) {
        this.window.refreshPiecesGrid(piecesIHMs);
    }
    
    
}
