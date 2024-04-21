package main.sgu.ru.ProducerConsumerTask;

public class Food {
    String name;
    Double calories;

    public Food(String name, Double calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.calories;
    }
}
