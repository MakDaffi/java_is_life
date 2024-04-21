package main.sgu.ru.ProducerConsumerTask;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable{
    private ArrayBlockingQueue<Food> sharedQueue;
    private Integer numFoods;
    private double MIN_CALORIES = 15.1;
    private double MAX_CALORIES = 1500.5;

    public Producer(ArrayBlockingQueue<Food> sharedQueue, Integer numFoods) {
        this.sharedQueue = sharedQueue;
        this.numFoods = numFoods;
    }

    public void run() {
        Random r = new Random();
        for (Integer i = 0; i < numFoods; i++) {
            Double calories = MAX_CALORIES + r.nextDouble() * (MAX_CALORIES - MIN_CALORIES);
            Food food = new Food("Food number " + i, calories);
            try {
                sharedQueue.put(food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
