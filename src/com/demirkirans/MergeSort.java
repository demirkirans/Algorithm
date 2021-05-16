package com.demirkirans;

public class MergeSort {
    
    /**
     * Merge sort algorithm
     * @param A array of numbers
     * @param p start index
     * @param r end index
     */
    public static void sort(int[] A, int p, int r) {
        //termination condition for recursive calls
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q+1, r);
            //merge two subarray
            Merge(A, p, q, r);
        }
    }
    
    /**
     * merges given two array
     * @param A given array that includes two subarray
     * @param p first index of left subarray
     * @param q last index of left subarray
     * @param r last index of right subarray
     */
    public static void Merge(int[] A, int p, int q, int r) {
        //find sizes of array for copy operation
        int n1 = q - p + 1;
        int n2 = r - q;
        //create two new arrays
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p+i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[j+q+1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r ; k++) {
            if (L[i] < R[j]) {
                A[k] = L[i];
                i = i + 1;
            }
            else {
                A[k] = R[j];
                j = j + 1;
            }
        }

    }
}
