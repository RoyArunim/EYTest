package com.assignment.EY.Multithreading4;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CQueue queue=new CQueue();
        int start=1;
        int end=10000;
        int mid1 = 1 + (end - start) / 3;
        int mid2 = start + 2 * (end - start) / 3;
        Thread t1=new Thread(new Worker(queue,start,mid1));
        Thread t2=new Thread(new Worker(queue, mid1+1, mid2));
        Thread t3=new Thread(new Worker(queue, mid2+1, end));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        AtomicReference<Double> sum = new AtomicReference<>(0.0);

        Thread producer = new Thread(() -> {
            while (queue.getSize() != 0) {
                double value = queue.poll();
                sum.updateAndGet(v -> v + value);
            }
        });

        producer.start();
        producer.join();
        System.out.println("Sum of logarithms is: "+sum);
    }
}
