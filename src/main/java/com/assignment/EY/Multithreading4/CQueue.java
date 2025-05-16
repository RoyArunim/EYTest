package com.assignment.EY.Multithreading4;


public class CQueue {
    Node front, rear;
    int size;
    public CQueue(){
        front=null;
        rear=null;
        size=0;
    }

    public synchronized void push(double x){
        Node newnode=new Node(x);
        if(front==null){
            front=rear=newnode;
            size++;
            return;
        }

        rear.next=newnode;
        rear=newnode;
        size++;
        return;
    }

    public synchronized double poll(){
        if(front==null) return -1;
        Node temp=front;
        front=front.next;
        double ans=temp.data;
        temp=null;
        size--;
        return ans;
    }

    public synchronized int getSize(){
        return size;
    }
}
