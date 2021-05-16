package com.demirkirans;

public class InsertionSort {

    /**
     * sorts given array using insertion sort algorithms
     * @param A given integer array
     */
    public static void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            //Insert A[i] into sorted sequence A[0 1 2 ... i-1]
            int j = i - 1;
            //traverse backward
            while(j >= 0 && A[j] > key ) {
                A[j+1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
    }
}

