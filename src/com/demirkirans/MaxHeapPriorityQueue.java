package com.demirkirans;

import java.util.NoSuchElementException;
import java.lang.Integer;

public class MaxHeapPriorityQueue extends MaxHeap  {
    
    public MaxHeapPriorityQueue() {
        super();
    }

    public MaxHeapPriorityQueue(int[] array, int heapSize) {
        super(array, heapSize);
        buildHeap();
    }

    /**
     * gives the element at root which is maximum
     * @return integer value of A[0]
     */
    public int maximum() {
        return this.A.get(0);
    }

    
    /**
     * Discard the max element and maintain the heap property
     * @return maximum
     */
    public int extractMax() {
        if (this.heapSize < 1) throw new NoSuchElementException("Heap has no element !!!");
        int max = this.maximum();
        //place the value at last node to the root
        int lastElement = this.A.get(this.heapSize - 1);
        this.A.set(0, lastElement);
        //remove it from collection
        this.A.remove(this.heapSize - 1);
        this.heapSize = this.heapSize - 1;
        heapify(0);
        return max;
    }

    /**
     * it first updates the key of element A[i] to its new value
     * Then, traverses a path from that node toward the root 
     * to find new proper place
     * @param i indice of element we wish to increase
     * @param key new value to be placed
     */
    public void increaseKey(int i, int key) {
        if (key < this.A.get(i)) {
            throw new IllegalArgumentException("new key is smaller than current key");
        }
        //update the key
        this.A.set(i, key);
        //check if new key violates heap property
        while(i > 0 && this.A.get(parent(i)) < this.A.get(i)) {
            //exchange A[i] with A[parent]
            int temp;
            temp = this.A.get(parent(i));
            this.A.set(parent(i), this.A.get(i));
            this.A.set(i, temp);
            //update parent node
            i = parent(i);
        }
    }

    /**
     * inserts new key and put it in a proper place 
     * @param key
     * @return true if it is inserted successfully
     */
    public boolean insertKey(int key) {
        this.A.add(Integer.MIN_VALUE);
        this.heapSize = this.heapSize + 1;
        try {
            increaseKey(this.heapSize - 1, key);
            return true;
        } catch (IllegalArgumentException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }
    }

}