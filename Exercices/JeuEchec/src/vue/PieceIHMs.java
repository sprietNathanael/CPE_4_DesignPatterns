/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import model.Couleur;

/**
 *
 * @author nathanael
 */
public interface PieceIHMs {

    /**
     * @return indice de la colonne où est positionnée la piece
     */
    public int getX();

    /**
     * @return indice de la ligne où est positionnée la piece
     */
    public int getY();

    /**
     * @return couleur de la piece
     */
    public Couleur getCouleur();

    /**
     * @return le nom de la pièce (Tour, Cavalier, etc.) attention le type ne
     * correspond pas forcément au nom de la classe
     */
    public String getName();

}
