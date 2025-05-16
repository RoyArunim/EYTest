package com.assignment.EY.Multithreading2;

import com.assignment.EY.Multithreading2.PriorityQueue.MaxHeap;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MaxHeap heap=new MaxHeap();
        long startMain=System.currentTimeMillis();
        AtomicLong timeForPriority100 = new AtomicLong(0);
        AtomicLong timeForPriority0 = new AtomicLong(0);
        for(int i=1;i<=10000;i++){
            if(i%100==0){
                heap.insert(i,i%200);
            }
        }

        Thread t1 = new Thread(new Worker(heap, timeForPriority100, timeForPriority0));
        Thread t2 = new Thread(new Worker(heap, timeForPriority100, timeForPriority0));
        Thread t3 = new Thread(new Worker(heap, timeForPriority100, timeForPriority0));
        Thread t4 = new Thread(new Worker(heap, timeForPriority100, timeForPriority0));
        Thread t5 = new Thread(new Worker(heap, timeForPriority100, timeForPriority0));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("Total time for priority 100 tasks: " + timeForPriority100.get() + " ms");
        System.out.println("Total time for priority 0 tasks: " + timeForPriority0.get() + " ms");
        System.out.println("Total runtime of the program: " + (System.currentTimeMillis()-startMain) + " ms");


    }

}
