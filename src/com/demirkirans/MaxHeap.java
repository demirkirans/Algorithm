package com.demirkirans;

public class MaxHeap extends Heap {

    public MaxHeap() {
        super();
    }

    public MaxHeap(int[] array, int heapSize) {
        super(array, heapSize);
    }
    
    
    /**
     * it maintains the heap property by pushing the value at A[i] to down
     * if it violates heap property
     * its runtime is O(lg(n)) in worst case
     * @param i index of value to be checked
     */
    protected void heapify(int i) {
        //find the indices of children of given node
        int left  = left(i);  //left child is at A[left]
        int right = right(i);        //right child is at A[right]

        //we need to find the child with greater key.
        int largest;

        //compare parent node with left child first
        //          (1) 4
        //             / \
        //            /   \
        //        (2)14  (3)21

        if (left < this.heapSize && this.A.get(left) > this.A.get(i)) {
            largest = left;
        } else {
            largest = i;
        }

        //largest node for now 
        //              (1) 4
        //                 / \
        //                /   \
        //  largest->  (2)14  (3)21

        //compare the largest node with right child also

        if (right < this.heapSize && this.A.get(right) > this.A.get(largest)) {
            //if value at right child is larger, update the largest.
            largest = right;
        }

        //largest node for now 
        //              (1) 4
        //                 / \
        //                /   \
        //               /     \
        //            (2)14  (3)21 <--largest


        //if largest value is not at the parent node
        //exchange A[i] with A[largest]

        if (largest != i) {
            int temp;
            temp = this.A.get(i);
            this.A.set(i, this.A.get(largest));
            this.A.set(largest, temp);
            //call the maxHeapify again
            //as it may violate heap property at subtree rooted at largest
            heapify(largest);
        }

        //after change
        //             (1) 21
        //                 / \
        //                /   \
        //               /     \
        //            (2)14  (3) 4 

    } 

    /**
     * Builds max heap representation of array
     * by calling maxHeapify recursively
     * Since we call half the length of array times maxHeapify  
     * Runtime is O(n * log(n)) 
     */
    public void buildHeap() {
        this.heapSize = this.A.size();
        //nodes indexed by greater than A.length / 2 are not needed bc they are leaves
        //no need to call maxHeapify for leaves that have no child nodes
        for (int i = (this.A.size() / 2) -1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * builds max-heap and sorts the array
     * by restoring max-heap property repeatedly
     */
    public void heapSort() {
        buildHeap();
        for (int i = this.A.size() -1; i >= 1; i--) {
            //exchange A[0] with A[i]
            int temp;
            temp = this.A.get(0);
            this.A.set(0, this.A.get(i));
            this.A.set(i, temp);
            //decrease heap size by one
            this.heapSize = this.heapSize - 1;
            //call max-heapify for the root
            heapify(0);
        }
    }

}
