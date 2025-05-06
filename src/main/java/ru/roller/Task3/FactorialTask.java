package ru.roller.Task3;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {
    private static int TRESHOLD = 2;
    private int start;
    private int n;

    public FactorialTask(int start, int n) {
        this.start = start;
        this.n = n;

    }
    @Override
    protected Integer compute() {
        if (n - start <= TRESHOLD) {
            return factorial(start, n);
        } else {
            int mid = (start + n) / 2;
            FactorialTask left = new FactorialTask(start, mid);
            FactorialTask right = new FactorialTask(mid + 1, n);

            left.fork();
            return right.compute() * left.join();
        }
    }

    public Integer factorial(int start, int end) {
        Integer factorial = 1;

        for (int i = start; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
