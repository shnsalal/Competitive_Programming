import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        int arr[]= {4, 5, 2, 10, 8};
        int[] res = printNGE(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


    // O(n^2)
    // public static int[] printNGE(int[] arr) {
    //     int[] res = new int[arr.length];
    //     int max;
    //     for (int i = arr.length-1; i >= 0; i--) {
    //         max = -1;
    //         for (int j = i-1; j >= 0; j--) {
    //             if(arr[j] < arr[i]) {
    //                 max = arr[j];
    //                 break;
    //             }
    //         }
    //         res[i] = max;
    //     }
    //     res[0] = -1;

    //     return res;
    //     }


    public static int[] printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            if(stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
                while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                } 
                if(stack.isEmpty()) {
                    list.add(-1);
                } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}