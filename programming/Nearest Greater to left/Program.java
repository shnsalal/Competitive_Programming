import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        int arr[]= {3, 2, 1};
        int[] res = printNGE(arr);
        System.out.println(res);
    }


    // O(n^2)
    // public static void printNGE(int[] arr) {
    //     int[] res = new int[n];
    //     int max = -1;
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = i+1; j < arr.length; j++) {
    //             if(arr[j] > arr[i]) {
    //                 max = arr[j];
    //                 break;
    //             }
    //         }
    //         res[i] = max;
    //     }
    //     res[n-1] = -1;

    //     return res;
    //     }
    // }


    public static int[] printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() <= arr[i]) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                } 
                if(stack.isEmpty()) {
                    list.add(-1);
                } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}