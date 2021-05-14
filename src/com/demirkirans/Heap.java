package com.demirkirans;

import java.util.ArrayList;

public abstract class Heap {

    protected ArrayList<Integer> A;
    protected int heapSize;

    /**
     * Constructor
     */
    public Heap() {
        this.heapSize = 0;
        this.A = new ArrayList<Integer>();
    }

    /**
     * Constructor
     * @param array array to be copied
     * @param heapSize how many numbers will be represented as heap within given array
     */
    public Heap(int[] array, int heapSize) {
        //allocate memory for A
        this.heapSize = heapSize;
        this.A = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            this.A.add(array[i]);
        }
    }

    /**
     * it maintains the heap property by pushing the value at A[i] to down
     * if it violates heap property
     * its runtime is O(lg(n)) in worst case
     * @param i index of value to be checked
     */
    protected abstract void heapify(int i);

    /**
     * Builds max heap representation of array
     * by calling heapify recursively
     * Since we call half the length of array times heapify  
     * Runtime is O(n * log(n)) 
     */
    abstract void buildHeap();

    /**
     * builds heap and sorts the array
     * by restoring heap property repeatedly
     */
    abstract void heapSort();

    /**
     * prints element of heap one by one
     */
    public void printHeap() {
        this.A.forEach(n -> System.out.print(n + ","));
        System.out.println("");
    }

    /**
     * returns index of parent node for current node
     * @param i index of current node as integer
     * @return index of parent node
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * gives index of left child
     * @param i index of current node as integer
     * @return index of left child
     */
    protected int left(int i) {
        return 2*i + 1;
    }

    /**
     * gives index of right child
     * @param i index of current node as integer
     * @return index of right child
     */
    protected int right(int i) {
        return 2*i + 2;
    }


}