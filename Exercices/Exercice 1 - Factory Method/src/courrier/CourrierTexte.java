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
public class CourrierTexte extends Courrier
{
	protected Contenu nouveauContenu()
	{
		return new ContenuTexte();
	}
}
