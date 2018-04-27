package courrier;

public class TestCourrier
{

    public static void main(String[] args)
    {
            //CourrierHtml courrierHtml = new CourrierHtml();
            Courrier<ContenuHtml> courrierHtml = new Courrier<ContenuHtml>(ContenuHtml.class);
            courrierHtml.prepare("adresse1@domaine", "texte1");
            System.out.println(courrierHtml);
            Courrier<ContenuTexte> courrierTexte = new Courrier<ContenuTexte>(ContenuTexte.class);
            courrierTexte.prepare("adresse2@domaine", "texte2");
            System.out.println(courrierTexte);
    }

}