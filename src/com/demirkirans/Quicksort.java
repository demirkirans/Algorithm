package com.demirkirans;

public class Quicksort {

    /**
     * Implementation of quick sort algorithm
     * @param A given array
     * @param p first index
     * @param r last index
     */
    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            sort(A, p, q-1);
            sort(A, q+1, r);
        }
    }
    
    /**
     * rearranges given array by selecting last element as pivot
     * @param A given array
     * @param p first index
     * @param r last index 
     * @return index q for further subarray calls
     */
    public static int Partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i = i + 1;
                //exchange A[i] with A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        //exchange A[i+1] with A[r]
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;

        return i + 1;
    }
}
