package ru.roller.sbundo.BlockingQueue;

public class BlockingQueue<T> {

    private final T[] blockingQueue;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private final int capacity;


    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.blockingQueue =(T[]) new Object[capacity];
    }

    public synchronized void enqueue(T item) throws InterruptedException { //PUT
        while (size == capacity) {
            wait();  // wait
        }
        blockingQueue[head] = item;
        head = (head + 1) % capacity;
        size++;
        notifyAll();
    }

    public synchronized T dequeue () throws InterruptedException {        //TAKE
        while (size == 0) {
            wait();
        }
        var task = (T) blockingQueue[tail];
        blockingQueue[tail] = null;
        tail = (tail + 1) % capacity;
        size--;
        notifyAll();

        return task;
    }

    public int size() {
        return size;
    }

}
