/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courrier;

/**
 *
 * @author nathanael
 */
public abstract class Courrier
{
	protected Contenu contenu;
	protected String destinataire;

	abstract protected Contenu nouveauContenu();	// Factory Method

	public void prepare(String destinataire, String texte)
	{
		this.destinataire = destinataire;
		contenu = nouveauContenu();
		contenu.encode(texte);
	}
	public String toString()
	{
		String st = "destinataire : " + destinataire + "\n";
		st += "contenu : " + contenu.toString();
		return st;
	}
}