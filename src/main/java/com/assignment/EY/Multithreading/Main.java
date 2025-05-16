package com.assignment.EY.Multithreading;

import com.assignment.EY.Multithreading.Queue.CQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CQueue queue=new CQueue();
        long startMain=System.currentTimeMillis();
        for(int i=1;i<=10000;i++){
            if(i%100==0){
                queue.push(i);
            }
        }

        Thread t1 = new Thread(new Worker(queue));
        Thread t2 = new Thread(new Worker(queue));
        Thread t3 = new Thread(new Worker(queue));
        Thread t4 = new Thread(new Worker(queue));
        Thread t5 = new Thread(new Worker(queue));
        Thread t6 = new Thread(new Worker(queue));
        Thread t7 = new Thread(new Worker(queue));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        System.out.println("Main thread run time "+(System.currentTimeMillis()-startMain));
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        System.out.println("Final runtime for the entire code: "+(System.currentTimeMillis()-startMain));

    }
}
