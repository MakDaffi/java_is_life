package main.sgu.ru.ProducerConsumerTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public void main(String[] args) {
        Integer numConsumers = Integer.parseInt(System.console().readLine("Enter number of consumers: "));
        Integer numFoods = Integer.parseInt(System.console().readLine("Enter number of foods: "));
        ArrayBlockingQueue<Food> sharedQueue = new ArrayBlockingQueue<>(numFoods);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numConsumers);
        for (Integer j = 0; j < numConsumers; j++) {
            executor.submit(() -> {
                new Consumer(sharedQueue).run();
            });
        }

        Thread producerThread = new Thread(new Producer(sharedQueue, numFoods));
        producerThread.start();
    }
}
