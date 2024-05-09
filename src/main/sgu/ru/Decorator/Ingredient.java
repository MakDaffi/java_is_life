package src.main.sgu.ru.Decorator;

public class Ingredient {
    private String name;

    public Ingredient(String ingredientName) {
        this.name = ingredientName;
    }

    public String addIngredient() {
        return "with " + this.name;
    }
}
