package com.assignment.EY.Multithreading2.PriorityQueue;

public class Node {
     int taskKey;
     int priorityValue;
    public Node(int key, int value){
        taskKey=key;
        priorityValue=value;
    }

    public synchronized int getKey(){
        return this.taskKey;
    }

    public synchronized int getValue(){
        return this.priorityValue;
    }
}
