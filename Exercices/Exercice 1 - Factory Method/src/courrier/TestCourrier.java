package courrier;

public class TestCourrier
{

    public static void main(String[] args)
    {
            CourrierHtml courrierHtml = new CourrierHtml();
            courrierHtml.prepare("adresse1@domaine", "texte1");
            System.out.println(courrierHtml);
            CourrierTexte courrierTexte = new CourrierTexte();
            courrierTexte.prepare("adresse2@domaine", "texte2");
            System.out.println(courrierTexte);
    }

}