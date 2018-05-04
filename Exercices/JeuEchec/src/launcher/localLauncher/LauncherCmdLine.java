package launcher.localLauncher;

import java.util.Observer;

import vue.ChessGameCmdLine;
import controler.ChessGameControlers;
import controler.controlerLocal.LocalChessGameControler;
import model.game.ChessGame;



/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame model;
		ChessGameControlers controler;	
		ChessGameCmdLine vue;
		
		model = new ChessGame();	
		controler = new LocalChessGameControler(model);
		
		new ChessGameCmdLine(controler);	
		
		vue = new ChessGameCmdLine(controler);
	
		vue.go();
	}

}
