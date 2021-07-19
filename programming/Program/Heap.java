// public class Heap {
//     public static void main(String[] args) {
//         MaxHeap maxHeap = new MaxHeap(5);
//         maxHeap.insert(10);
//         maxHeap.insert(20);
//         maxHeap.insert(30);
//         maxHeap.insert(40);
//         maxHeap.insert(50);
//         maxHeap.heapSort();
//         maxHeap.heapSort();
//         maxHeap.heapSort();
//         maxHeap.heapSort();
//         maxHeap.heapSort();
//         maxHeap.displayHeapSort();
//     }
// }

// class MaxHeap {
//     int[] arr;
//     int size;
//     public MaxHeap(int capacity) {
//         arr = new int[capacity + 1];
//         size = 0;
//     }
//     public void insert(int data) {
//         if(size <= arr.length) {
//             size++;
//             arr[size] = data;
//             heapify();
//         } else {
//             System.out.println("No enough space");
//         }
       
//     }

//     public void delete() {
//         if(size > 0) {
//             arr[1] = arr[size];
//             arr[size] = 0;
//             heapifyTopToBottom();
//             size--;
//         } else {
//             System.out.println("no data to delete");
//         }
//     }

//     public void heapifyTopToBottom() {
//         int s = 1;
//         while((arr[s] < arr[leftChild(s)] || arr[s] < arr[rightChild(s)]) && !isLeaf(s)) {
//             if(arr[leftChild(s)] > arr[rightChild(s)]) {
//                 swap(s, leftChild(s));
//             } else {
//                 swap(s,  rightChild(s));
//             }
//         }
//     }

//     public void heapify() {
//         int s = size;
//         while(s > 1  && arr[s] > arr[parent(s)]) {
//             swap(s, parent(s));
//             s = parent(s);
//         }
//     }

//     public void swap(int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     public int leftChild(int i) {
//         return 2*i;
//     }

//     public int rightChild(int i) {
//         return 2*i+1;
//     }

//     public int parent(int i) {
//         return i/2;
//     }

//     public boolean isLeaf(int s) {
//         if(s >= 1 && size/2 < s) {
//             return true;
//         }
//         return false;
//     }

//     public void display() {
//         for (int i = 1; i <= size; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }

//     public void heapSort() {
//         if(size > 0) {
//             heapifyTopToBottom();
//             swap(1, size);
//             size--;
//             // heapifyTopToBottom();
//         } else {
//             System.out.println("no data to delete");
//         }
//     }

//     public void displayHeapSort() {
//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }
// }
