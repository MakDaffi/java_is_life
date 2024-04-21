package main.sgu.ru;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class IncrementTask {
    private Integer curIncrement = 0;
    private Object mutex = new Object();

    public void main(String[] args) {
        Integer incrementNum = 100000; 
        Integer threadNum = 2;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);
        for (Integer j = 0; j < incrementNum; j++) {
            executor.submit(() -> {
                getNextIncrement();
            });
        }
        executor.shutdown();
    }

    public void getNextIncrement() {
        synchronized (this.mutex) {
            curIncrement++;
            System.out.println(this.curIncrement);
        }
    }
}
