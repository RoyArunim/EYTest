package com.assignment.EY.Multithreading3.Queue;

public class BQueue {
    private final int[] buffer;
    private int capacity;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public BQueue(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public synchronized void push(int item) throws InterruptedException {
        // Wait while the buffer is full
        while (size == capacity) {
            wait();
        }

        buffer[rear] = item;
        rear = (rear + 1) % capacity;
        size++;

        notifyAll(); // Notify any waiting consumers
    }

    public synchronized int poll() throws InterruptedException {
        // Wait while the buffer is empty
        while (size == 0) {
            wait();
        }

        int item = buffer[front];
        front = (front + 1) % capacity;
        size--;

        notifyAll(); // Notify any waiting producers
        return item;
    }
    public synchronized int getSize() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized boolean isFull() {
        return size == capacity;
    }
}
