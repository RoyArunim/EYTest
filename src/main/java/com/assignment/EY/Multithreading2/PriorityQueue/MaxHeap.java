package com.assignment.EY.Multithreading2.PriorityQueue;

import java.util.ArrayList;

public class MaxHeap {
    public ArrayList<Node> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public synchronized void insert(int key, int val) {
        Node newHeapNode=new Node(key, val);
        heap.add(newHeapNode);
        int currIdx = heap.size() - 1;
        while (currIdx > 0 && heap.get(currIdx).priorityValue > heap.get(parent(currIdx)).priorityValue) {
            swap(currIdx, parent(currIdx));
            currIdx = parent(currIdx);
        }
    }
    public synchronized Node peek() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public synchronized boolean isEmpty(){
        return heap.isEmpty();
    }


    public synchronized Node poll() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap Empty");
        }

        Node max = heap.get(0);
        Node lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);


            int currIdx = 0;
            while (true) {
                int left = leftChild(currIdx);
                int right = rightChild(currIdx);
                int largest = currIdx;

                if (left < heap.size() && heap.get(left).priorityValue > heap.get(largest).priorityValue) {
                    largest = left;
                }

                if (right < heap.size() && heap.get(right).priorityValue > heap.get(largest).priorityValue) {
                    largest = right;
                }

                if (largest == currIdx) {
                    break;
                }

                swap(currIdx, largest);

                currIdx = largest;
            }
        }
        return max;
    }
}
