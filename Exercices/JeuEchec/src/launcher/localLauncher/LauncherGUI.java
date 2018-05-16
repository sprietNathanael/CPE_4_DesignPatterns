package launcher.localLauncher;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

import controler.ChessGameControlers;
import controler.controlerLocal.LocalChessGameControler;
import model.game.ChessGame;
import tools.CustomObserver;
import vue.ChessGameGUI;



/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode graphique.
 * La vue (ChessGameGUI) observe le modèle (ChessGame)
 * les échanges passent par le contrôleur (ChessGameControlers)
 * 
 */
public class LauncherGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGame chessGame;	
		ChessGameControlers chessGameControler;
		ChessGameGUI gui;	
		Dimension dim;
	
		dim = new Dimension(700, 700);
		
		chessGame = new ChessGame();	
		chessGameControler = new LocalChessGameControler(chessGame);
		
		gui = new ChessGameGUI("Jeu d'échec", chessGameControler,  dim);
		chessGame.addObserver((CustomObserver) gui);
		
		
	}
}
