package com.assignment.EY.Multithreading;

import com.assignment.EY.Multithreading.Queue.CQueue;

public class Worker implements Runnable {

    CQueue queue;
    long start=0;
    public Worker(CQueue queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        start=System.currentTimeMillis();
        while(queue.getSize()!=0){
            Integer task = queue.poll();
            System.out.println("Consumed task: "+task);
            try {
                Thread.sleep(task);
                double ans = Math.log(task);
                System.out.println("The Log value is = "+ans);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Time taken to run all tasks in background thread: "+Thread.currentThread().getName()+" is = "+(System.currentTimeMillis()-start));
    }
}
