package main.sgu.ru;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibCalc extends RecursiveTask<Integer>{
    private Integer n;

    public FibCalc(Integer n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n < 2) {
            return n;
        } else {
            FibCalc num1 = new FibCalc(n - 1);
            num1.fork();
            FibCalc num2 = new FibCalc(n - 2);
            num2.fork();
            return num1.compute() + num2.compute();
        }
    }

    public static void main(String[] args) {
        Integer n = Integer.parseInt(System.console().readLine("Enter n: "));
        FibCalc fibCalc = new FibCalc(n);
        ForkJoinPool pool = new ForkJoinPool();
        Integer res = pool.invoke(fibCalc);
        System.out.println("Result: " + res);
    }
}
