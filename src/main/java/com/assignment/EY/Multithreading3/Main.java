package com.assignment.EY.Multithreading3;

import com.assignment.EY.Multithreading3.Queue.BQueue;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        BQueue queue=new BQueue(5);
        long startMain=System.currentTimeMillis();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10000; i++) {
                    if (i % 100 == 0) {
                        queue.push(i);
                        System.out.println("Produced: " + i);
                    }
                }
                // Send poison pills
                queue.push(-1);
                queue.push(-1);
                queue.push(-1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();

        Thread t1 = new Thread(new Worker(queue));
        Thread t2 = new Thread(new Worker(queue));
        Thread t3 = new Thread(new Worker(queue));

        t1.start();
        t2.start();
        t3.start();
        producer.join();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Total running time: "+(System.currentTimeMillis()-startMain));
    }



}
