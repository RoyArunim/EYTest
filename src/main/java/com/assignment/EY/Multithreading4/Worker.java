package com.assignment.EY.Multithreading4;


public class Worker implements Runnable {
    final CQueue queue;
    int start;
    int end;
    public Worker(CQueue queue,int start,int end){
        this.queue=queue;
        this.start=start;
        this.end=end;
    }
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 100 == 0) {
                synchronized (queue) {
                    double ans = Math.log(i);
                    queue.push(ans);
                    System.out.println("Pushed into queue by " + Thread.currentThread().getName());
                }
            }
        }
    }
}
