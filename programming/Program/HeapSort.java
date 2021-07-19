
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,3,20, 10,78};

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.heapSort(arr);
        maxHeap.displayHeapSort(arr);
    }
}

class MaxHeap {

    public void heapSort(int[] arr) {
        int len = arr.length/2;
        for (int i = len-1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }

        int l = arr.length-1;
        for (int i = l; i >= 0; i--) {
            swap(0, i, arr);
            heapify(arr, 0, i);
        }
    }

    public void heapify(int[] arr, int pos, int  l) {
        // boolean leaf = isLeaf(pos);
        int left =  leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;

        if(left < l  && arr[left] > arr[largest]) {
            largest = left;
        }

        if( right < l && arr[largest] < arr[right]) {
            largest = right;
        } 

        if(largest != pos) {
            swap(largest, pos, arr);
            heapify(arr, largest, l);
        }
    }

    public void heapifyBottomToTop(int[] arr, int l) {
        while(l != 0) {
            if(parent(l) < arr[l]) {
                swap(l, parent(l), arr);
            }
            l = parent(l);
        }
    }

    // public void heapify(int[] arr, int pos) {
    //     boolean leaf = isLeaf(pos);
    //     int left =  leftChild(pos);
    //     int right = rightChild(pos);

    //     if(leaf) {
    //         return;
    //     }

    //     if(arr[pos] < arr[left] || arr[pos] < arr[right]) {
    //         if(arr[left] > arr[right]) {
    //             swap(pos, left, arr);
    //             heapify(arr, left);
    //         } else {
    //             swap(pos, right, arr);
    //             heapify(arr, right);
    //         } 
    //     }
    // }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int leftChild(int i) {
        return 2*i+1;
    }

    public int rightChild(int i) {
        return 2*i+2;
    }

    public int parent(int i) {
        return (i-1)/2;
    }

    // public boolean isLeaf(int i) {
    //     if(i > arr.length/2-1) {
    //         return true;
    //     }
    //     return false;
    // }

    public void displayHeapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}