package ru.roller.sbundo.CyclicBarier;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexTaskExecutor {
    int taskCount;

    public ComplexTaskExecutor(int taskCount) {
        this.taskCount = taskCount;
    }

    public void executeTasks(int numberOfTasks) {
        AtomicInteger palindromeCount = new AtomicInteger(0);
        AtomicInteger cointer = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);
        CyclicBarrier barrier = new CyclicBarrier(5, () ->
                System.out.println("Total palindrome count " + palindromeCount.get()));

        for(int i = 0; i < taskCount; i++) {
            executorService.execute(new ComplexTask(barrier, palindromeCount, cointer));
        }

        executorService.shutdown();
    }
}
