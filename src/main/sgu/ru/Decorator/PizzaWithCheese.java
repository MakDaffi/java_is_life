package src.main.sgu.ru.Decorator;

public class PizzaWithCheese extends BasePizza{
    public String cook() {
        return super.cook() + addCheese();
    }

    public String addCheese() {
        return " with cheese";
    }
}
