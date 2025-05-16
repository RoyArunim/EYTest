package com.assignment.EY.Multithreading3;

import com.assignment.EY.Multithreading3.Queue.BQueue;

public class Worker implements Runnable {
    private final BQueue queue;
    long start;

    public Worker(BQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        start = System.currentTimeMillis();
        while (true) {
            try {
                int task = queue.poll();
                if (task == -1) {
                    break; // signal to exit
                }
                System.out.println("Task: "+task+" is being processed by "+Thread.currentThread().getName());
                Thread.sleep(task);
                double ans = Math.log(task);
                System.out.println("The Log value is = " + ans);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Time taken to run all tasks in background thread: " + Thread.currentThread().getName() + " is = " + (System.currentTimeMillis() - start));
    }
}
