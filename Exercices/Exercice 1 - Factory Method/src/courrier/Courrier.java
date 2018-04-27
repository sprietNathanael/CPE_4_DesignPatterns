/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courrier;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nathanael
 */
public class Courrier<T extends Contenu>
{

    public Courrier(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    
    Class<T> clazz;
    private T contenu;
    private String destinataire;

    private void nouveauContenu()
    {
        try {
            this.contenu = clazz.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Courrier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Courrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepare(String destinataire, String texte)
    {
            this.destinataire = destinataire;
            this.nouveauContenu();
            this.contenu.encode(texte);
    }
    public String toString()
    {
            String st = "destinataire : " + destinataire + "\n";
            st += "contenu : " + contenu.toString();
            return st;
    }
}