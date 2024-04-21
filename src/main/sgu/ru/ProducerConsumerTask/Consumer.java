package main.sgu.ru.ProducerConsumerTask;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable{
    private static final Integer NAME_LEN = 10;

    private ArrayBlockingQueue<Food> sharedQueue;
    private String name = genRandomStr(NAME_LEN);
    private Double caloriesEaten = 0.0;

    public Consumer(ArrayBlockingQueue<Food> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    private static String genRandomStr(Integer charNums) {
        byte[] array = new byte[charNums];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        
        return generatedString;
    }

    public void run() {
        while (true) {
            final Food food;
            try {
                food = sharedQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            caloriesEaten += food.calories;
            System.out.println(this.name + " eaten " + food + ". Now he/she has eaten " + caloriesEaten + " calories!");
        }
    }
}
