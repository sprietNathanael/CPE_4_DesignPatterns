public class WidgetMeteo implements Observateur {
    protected DonneesMeteo donneesMeteo;
    protected double temperature;
    protected double pression;
    protected double tauxHumidite;

    public WidgetMeteo(DonneesMeteo donneesMeteo) {
        this.donneesMeteo = donneesMeteo;
        donneesMeteo.ajoute(this);
        actualise();
    }

    public void actualise() {
        temperature = donneesMeteo.getTemperature();
		pression = donneesMeteo.getPression();
        tauxHumidite = donneesMeteo.getTauxHumidite();
        affiche();
    }

    public void affiche() {
        System.out
                .println("Le Widget affiche une temp�rature de: "
                        + temperature
                        + ", une pression de: "
                        + pression
                        + " et un taux d�humidit� de:"
                        + tauxHumidite);
    }
}
