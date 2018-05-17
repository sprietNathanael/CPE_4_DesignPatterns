package vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import tools.ChessImageProvider;
import tools.ChessPiecePos;
import controler.ChessGameControlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import model.Couleur;


/**
 * @author francoise.perrin -
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD -
 * Inspiration http://www.roseindia.net/java/example/java/swing/chess-application-swing.shtml
 * 
 *  IHM graphique d'un jeu d'echec 
 *  Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 *  
 */

public class ChessGameWindow extends JFrame implements MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// controleur de l'objet métier
	private ChessGameControlers chessGameControler;

	// Taille de la fenêtre
	private Dimension boardSize;

	//Panneau stratifie permettant de superposer plusieurs couches
	// visibles les unes sur les autres
	private JLayeredPane layeredPane;

	//plateau du jeu d'echec permettant de contenir tous les objets graphiques
	private JPanel chessBoardGuiContainer;

	//piece selectionnee
	private JLabel pieceToMove;

	// Coord de la pièce sélectionnée
	private Coord initCoord;

	// coordonnee qui permettront de recadrer une piece 
	// au milieu du carre lors d'un deplacement  (drag)
	private int xAdjustment;
	private int yAdjustment;
        
        
        
	/**
	 * 
	 * Construit le plateau de l'echiquier sous forme de damier 8*8
	 * et le rend ecoutable par les evenements 
	 * MouseListener et MouseMotionListener.
	 *   
	 * Sont superposes 1 JPanel pour le plateau et
	 * autant de JPanel que de carres noirs ou blancs
	 * sur lesquels seront positionnees les pieces aux bonnes coordonnees.
	 * 
	 * Les images des pieces et leurs coordonnees 
	 * seront fournies par des utilitaires.
	 *
	 * 
	 * @param name - nom de la fenetre

	 * @param chessGameControler - 
	 * @param boardSize - taille de la fenetre
	 */
	public ChessGameWindow(String name, ChessGameControlers chessGameControler, Dimension boardSize) {
		super(name);		

		this.chessGameControler = chessGameControler;  
		this.boardSize = boardSize;

		this.initCoord = null;
		this.pieceToMove = null;

		// construit le plateau de l'echiquier sous forme de damier 8*8  	
		this.layeredPane = new JLayeredPane();		
		this.chessBoardGuiContainer = new JPanel();	
		this.drawGrid();

		// Ajout des écouteurs pour écouter les évènements souris
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// le remplissage du damier avec les pièces disposées
		// en fonction de leur place initiale lors de la création de l'échiquier
		// est effectué après appel du constructeur
		// lorsque la vue s'enregistre auprès du ChessGame en tant qu'Observer
		// sa méthode update() est invoquée

		// sinon, si la méthode update() n'est pas invoquée
		// par une notification au démarrage du jeu
		// le remplissage est effectué par la ligne suivante à décommenter :
		 this.initFillGrid();
                 
	}


	/**
	 *  construit le plateau de l'echiquier sous forme de damier 8*8  	
	 */
	private void drawGrid(){

		JPanel square = null;

		this.setContentPane(this.layeredPane);	
                this.layeredPane.removeAll();
		this.layeredPane.add(this.chessBoardGuiContainer, JLayeredPane.DEFAULT_LAYER);
		this.chessBoardGuiContainer.setLayout( new GridLayout(8, 8) );
		this.chessBoardGuiContainer.setBounds(0, 0, boardSize.width-10, boardSize.height-30);
                
		// remplissage du damier avec les carres 
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8; j++) {

				// creation d'un JPanel pour le carre blanc ou noir
				square = new JPanel( new BorderLayout() );
				int row = i % 2;
				if (row == 0) {
					square.setBackground( j % 2 != 0 ? new Color(139,69,0) : new Color(255,250,240)  ); 
				}
				else {
					square.setBackground( j % 2 != 0 ? new Color(255,250,240): new Color(139,69,0) );
				}
                            
				// ajout du carre sur le damier
				this.chessBoardGuiContainer.add( square );
			}
		}
                	}



	/**
	 * Remplit le plateau de l'echiquier sur lequel  
	 * sont superposes 1 JPanel pour le plateau et
	 * autant de JPanel que de carres noirs ou blancs
	 * avec des JLabel pour les images des pièces
	 * 
	 * Méthode appelée lors de construction de la JFrame
	 * au cas où l'update ne serait pas appelé après la construction
	 * (si pas de notification des observateurs lors du addObserver() ds main())
	 */	 
	private void initFillGrid(){  

		JLabel piece;
		JPanel panel;
		for (int i = 0; i < ChessPiecePos.values().length; i++) {

			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
				piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom, ChessPiecePos.values()[i].couleur)));
				panel = (JPanel) chessBoardGuiContainer.getComponent((ChessPiecePos.values()[i].coords[j].x) + (ChessPiecePos.values()[i].coords[j].y * 8));
				panel.add(piece);
			}
		}
	}
        
        public void refreshPiecesGrid(List<PieceIHMs> piecesIHM)
        {
            JLabel piece;
            JPanel panel;
            /*for(Iterator<Component> iter = Arrays.asList(chessBoardGuiContainer.getComponents()).listIterator(); iter.hasNext())
            {
                Component component = iter.next();
                chessBoardGuiContainer.remove(component);
            }*/
            chessBoardGuiContainer.removeAll();
            drawGrid();
            for (Iterator<PieceIHMs> iter = piecesIHM.listIterator(); iter.hasNext(); ) {
                PieceIHMs pieceIHM = iter.next();
                piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(pieceIHM.getName(), pieceIHM.getCouleur())));
                panel = (JPanel) chessBoardGuiContainer.getComponent((pieceIHM.getX()) + (pieceIHM.getY() * 8));
                panel.add(piece);
            }
            chessBoardGuiContainer.repaint();
        }

	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e){

		Point pieceToMoveLocation = null;
		JPanel square = null;

		this.initCoord = null;
		this.pieceToMove = null;

		Component c =  this.chessBoardGuiContainer.findComponentAt(e.getX(), e.getY());

		// si l'utilisateur a selectionné une piece
		if (c instanceof JLabel) {

			// calcul des coordonnées initiales
			this.initCoord = translateCoord(e.getX(), e.getY());


			// Si c'est bien le tour de jeu du joueur
			if (this.chessGameControler.isPlayerOK(initCoord))	{

				this.pieceToMove = (JLabel)c;

				// Mise en place du déplacement visuel de l'image de la pièce
				square=(JPanel)c.getParent();
				pieceToMoveLocation = square.getLocation();
				this.xAdjustment = pieceToMoveLocation.x - e.getX();
				this.yAdjustment = pieceToMoveLocation.y - e.getY();
				this.pieceToMove.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
			
				this.layeredPane.add(pieceToMove, JLayeredPane.DRAG_LAYER);


				// Mise en évidence des cases vers lesquelles 
				// la pièce peut être déplacée 	
                                this.paintPossibilites();
				
                                
			}
		}
	}
        
        private void paintPossibilites()
        {
            List<Coord> possibilities = this.chessGameControler.getAllPossiblePlacements(this.initCoord);
            JPanel square = null;

            for (Iterator<Coord> iterator = possibilities.iterator(); iterator.hasNext();) {
                Coord currentCoord = iterator.next();
                square = (JPanel)this.chessBoardGuiContainer.getComponent((currentCoord.y*8)+currentCoord.x);
                square.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
                square.revalidate();
                square.repaint();
                
                
            }
        }


	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.pieceToMove != null) {
			this.pieceToMove.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

		Coord  finalCoord = null ;

		if(this.pieceToMove != null) {

			this.pieceToMove.setVisible(false);

			finalCoord = translateCoord(e.getX(), e.getY());
			

			// Si les coordonnees finales sont en dehors du damier, on les force à -1
			// cela permettra à la methode chessGame.move de gerer le message d'erreur
			if (finalCoord == null){
				finalCoord = new Coord(-1, -1);
			}

			// Invoque la methode de deplacement de l'echiquier	
			// qui invoque aussi la méthode de promotion du pion si besoin
			this.chessGameControler.move(this.initCoord, finalCoord);

			// l'echiquier étant observé par cette vue (fenetre)
			// des lors qu'il est modifie par l'invocation de la méthode move(),
			// la vue en est avertie et
			// sa methode update est appelee pour rafraichir l'affichage du damier


		}
	}

	/**
	 * @param xpixel
	 * @param ypixel
	 * @return les coordonnées en base 8*8
	 */
	private Coord translateCoord(int xpixel, int ypixel) {	
		Coord coord = null;
		Double x = new Double(Math.floor(((double) xpixel / (this.boardSize.width-10)) * 8));
		Double y = new Double(Math.floor(((double) ypixel / (this.boardSize.height-30)) * 8));
		coord = new Coord(x.intValue(), y.intValue());
		return coord;
	}
        
        private Coord translateToPixels(Coord coords)
        {
            Coord pixels = null;
            Double x = new Double(Math.floor(((this.boardSize.width-10) / (double)8) * coords.x));
            Double y = new Double(Math.floor(((this.boardSize.width-30) / (double)8) * coords.y));
            pixels = new Coord(x.intValue(), y.intValue());
            return pixels;
        }

	@Override	
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e){

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
