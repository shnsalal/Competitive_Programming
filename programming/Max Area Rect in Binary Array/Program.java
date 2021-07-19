import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Program {
  public static void main(String[] args) {
    char[][] matrix = {{0,1,1,0},
                     {1,1,1,1},
                     {1,1,1,1},
                     {1,1,0,0}}; 
    // int[][] matrix = {{0,0}}; 
    int[][] mat = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            mat[i][j] = matrix[i][j];
        }
    }
   
    
    System.out.println(maxReactangle(mat)); 
  }

  public static int maxReactangle(int[][] matrix) {
    int max = 0;
    int[] matrixOne = new int[matrix[0].length]; 
    for (int i = 0; i < matrix[0].length; i++) {
        matrixOne[i] = matrix[0][i];
    }

    int MAH = getMAH(matrixOne);
    max = Math.max(max, MAH);
    for (int i = 1; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] != 0) {
                matrixOne[j] = matrix[i][j]+matrixOne[j];
            } else {
                matrixOne[j] = 0;
            }
        }
        MAH = getMAH(matrixOne);
        max = Math.max(max, MAH);
    }
    return max;
  }

  public static int getMAH(int[] A) {
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