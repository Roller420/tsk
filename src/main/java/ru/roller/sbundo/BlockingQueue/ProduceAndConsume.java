package ru.roller.sbundo.BlockingQueue;


public class ProduceAndConsume {
    private BlockingQueue <String> queue;
    private static final Object printLock = new Object();

    public ProduceAndConsume(BlockingQueue queue) {
        this.queue = queue;

    }
    public void produce(String value) throws InterruptedException {
        queue.enqueue(value);

        synchronized (printLock) {
            System.out.println("Value Produсed " + value);
        }
    }

    public void consume() throws InterruptedException {
        String value = queue.dequeue();
        StringBuilder sb = new StringBuilder(value);

        synchronized (printLock) {
            System.out.println("Value Consumed " + value);
            System.out.println("Value reversed " + sb.reverse().toString());
            System.out.println();
        }
    }
}
