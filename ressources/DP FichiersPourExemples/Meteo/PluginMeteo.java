public class PluginMeteo implements Observateur {
    protected DonneesMeteo donneesMeteo;
    protected double temperature;
    protected double pressionCourante, dernierePression;
   

    public PluginMeteo(DonneesMeteo donneesMeteo) {
        this.donneesMeteo = donneesMeteo;
        donneesMeteo.ajoute(this);
        this.actualise();
    }

    public void actualise() {
        temperature = donneesMeteo.getTemperature();
        dernierePression = pressionCourante;
		pressionCourante = donneesMeteo.getPression();
        affiche();
    }

	public void affiche()
	{
		System.out.println("Le Plugin affiche une temp�rature de: "
						+ temperature);
		System.out.print("Pr�vision : ");
		if (pressionCourante > dernierePression)
		{
			System.out.println("Am�lioration en cours !");
		}
		else if (pressionCourante == dernierePression)
		{
			System.out.println("Le temps se rafra�chit");
		}
		else if (pressionCourante < dernierePression)
		{
			System.out.println("D�pression bien install�e");
		}
	}
}
	