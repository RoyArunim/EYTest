//package com.assignment.EY.Multithreading;
//
//import com.assignment.EY.Queue.CQueue;
//
//import java.sql.SQLOutput;
//
//public class SharedResource {
//    CQueue queue=new CQueue();
//    int buffersize=200;
//
//    public synchronized void produce( int item) throws InterruptedException {
//        if(queue.getSize()==buffersize){
//            System.out.println("The Queue is full");
//            wait();
//        }
//
//        queue.push(item);
//        System.out.println("Added item to queue");
//        notify();
//    }
//    public synchronized int consume() throws InterruptedException {
//        while(queue.getSize()==0){
//            System.out.println("Queue is empty");
//            wait();
//        }
//        int item=queue.poll();
//        System.out.println("Consumed item");
//        notify();
//        return item;
//    }
//}
