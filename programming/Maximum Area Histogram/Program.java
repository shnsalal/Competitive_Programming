import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {
      int[] stock = { 2,1,5,6,2,3}; 
      System.out.println(MAH(stock)); 
    }
    
    public static int MAH(int[] A) {
        int [] NSR = findNSR(A);
        int [] NSL = findNSL(A);
        int max;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            max = ((NSR[i] - NSL[i]) - 1) * A[i];
            res = Math.max(res, max);
        }
        return res;
    }

    public static int[] findNSR(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = arr.length-1; i >= 0; i--) {
            if (stack.empty()) {
                list.add(arr.length);
            } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                list.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                while(!stack.isEmpty() && stack.peek().value >= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    list.add(arr.length);
                } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                    list.add(stack.peek().index);
                } 
            }
            stack.add(new Pair(arr[i], i));
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] findNSL(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                list.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                while(!stack.isEmpty() && stack.peek().value >= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    list.add(-1);
                } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                    list.add(stack.peek().index);
                } 
            }
            stack.add(new Pair(arr[i], i));
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}