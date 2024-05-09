package src.main.sgu.ru.Decorator;

public class Pizza {
    private Ingredient[] ingredients;

    public Pizza(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public String cook() {
        String ingredientsString = "";
        for (Ingredient ingredient : this.ingredients) {
            ingredientsString += ingredient.addIngredient() + " ";
        }
        return "Pizza " + ingredientsString;
    }
}
