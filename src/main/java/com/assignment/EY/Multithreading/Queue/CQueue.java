package com.assignment.EY.Multithreading.Queue;

public class CQueue {
    Node front, rear;
    int size;
    public CQueue(){
        front=null;
        rear=null;
        size=0;
    }

    public synchronized void push(int x){
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

    public synchronized int poll(){
        if(front==null) return -1;
        Node temp=front;
        front=front.next;
        int ans=temp.data;
        temp=null;
        size--;
        return ans;
    }

    public synchronized int getSize(){
        return size;
    }

}
