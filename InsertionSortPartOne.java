// Sample Input
// 5
// 2 4 6 8 3

// Sample Output
// 2 4 6 8 8 
// 2 4 6 6 8 
// 2 4 4 6 8 
// 2 3 4 6 8 

import java.util.ArrayList;
import java.util.List;

public class InsertionSortPartOne {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = { 2, 4, 6, 8, 3 };

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        insertionSort1(arr.length, list);

    }

    public static void insertionSort1(int n, List<Integer> arr) {
        int[] array = arr.stream().mapToInt(x -> x).toArray();

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                for (int k = 0; k < n; k++) {
                    System.out.print(array[k] + " ");
                }
                System.out.println();
            }
            array[j + 1] = key;
        }
        for (int k = 0; k < n; k++) {
            System.out.print(array[k] + " ");
        }
    }
}
