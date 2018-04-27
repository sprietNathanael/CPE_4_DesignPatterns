package tetepremiere.fabrique.pizzaaf;

public class PizzaFromage extends Pizza {
	FabriqueIngredientsPizza fabriqueIngredients;
 
	public PizzaFromage(FabriqueIngredientsPizza fabriqueIngredients) {
		this.fabriqueIngredients = fabriqueIngredients;
	}
 
	void preparer() {
		System.out.println("Préparation de " + nom);
		pate = fabriqueIngredients.creerPate();
		sauce = fabriqueIngredients.creerSauce();
		fromage = fabriqueIngredients.creerFromage();
	}
}
