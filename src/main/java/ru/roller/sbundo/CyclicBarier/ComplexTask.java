package ru.roller.sbundo.CyclicBarier;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexTask implements Runnable {
    private static List<String> list = List.of("An eye for an eye", "Next level", "You're god damn right", "First gig",
            "My favorite drink is karak", "Oh my God", "BBQ bakin burger");
    private CyclicBarrier cyclicB;
    private AtomicInteger palindromeCount;
    private AtomicInteger counter;


    public ComplexTask(CyclicBarrier cyclicBarrier, AtomicInteger palindromeCount, AtomicInteger counter) {
        this.cyclicB = cyclicBarrier;
        this.palindromeCount = palindromeCount;
        this.counter = counter;
    }

    @Override
    public void run() {
        this.execute(list);
        try {
            cyclicB.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(List<String> list) {
        String line = list.get(counter.getAndIncrement());

        String[] splittedLine = line.split(" ");


        for (int i = 0; i < splittedLine.length; i++) {
            String original = splittedLine[i].toLowerCase();
            String reversed = reverse(original).toLowerCase();

            if (original.equals(reversed))
            palindromeCount.incrementAndGet();
            synchronized (this) {
                System.out.println("Поток " + Thread.currentThread() +  "завершился с количеством палиндромов " + palindromeCount + ". Ждём других");
            }
        }
    }

    public static String reverse(String line) {
        StringBuilder sb = new StringBuilder(line);
        return sb.reverse().toString();
    }
}
