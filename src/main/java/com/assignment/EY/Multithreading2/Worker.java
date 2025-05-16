package com.assignment.EY.Multithreading2;

import com.assignment.EY.Multithreading2.PriorityQueue.MaxHeap;
import com.assignment.EY.Multithreading2.PriorityQueue.Node;

import java.util.concurrent.atomic.AtomicLong;

public class Worker implements Runnable {
    MaxHeap heap;
    long start;
    AtomicLong timeForPriority100;
    AtomicLong timeForPriority0;
    public Worker(MaxHeap heap, AtomicLong timeForPriority100, AtomicLong timeForPriority0){
        this.heap=heap;
        this.timeForPriority100 = timeForPriority100;
        this.timeForPriority0 = timeForPriority0;
    }

    @Override
    public void run() {
        start=System.currentTimeMillis();
        while(!heap.isEmpty()){
            Node task;
            synchronized(heap){
                if (heap.isEmpty()) break;
                task = heap.poll();
            }

            System.out.println("Priority for this task is: "+task.getValue());
            System.out.println("Consumed task is: "+task.getKey());
            try {
                Thread.sleep(task.getKey());
                double ans = Math.log(task.getKey());
                System.out.println("The Log value is = "+ans);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long duration = System.currentTimeMillis()-start;
            //aim is the calculate cumulated duration of priority100 and priority0 tasks separately, hence inside while loop
            if (task.getValue() == 100) {
                timeForPriority100.addAndGet(duration);
            } else if (task.getValue() == 0) {
                timeForPriority0.addAndGet(duration);
            }
        }
    }
}
