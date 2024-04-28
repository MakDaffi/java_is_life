package src.main.sgu.ru.Decorator;

public class PizzaWithPepperoni extends BasePizza{
    public String cook() {
        return super.cook() + addPepperoni();
    }

    public String addPepperoni() {
        return " with pepperoni";
    }
}
