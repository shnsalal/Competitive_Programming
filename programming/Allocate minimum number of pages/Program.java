import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        int[] arr = new int[] { 13, 7, 6, 12 };
        nextGreaterElement(arr);
    }

    private static void nextGreaterElement(int[] arr) {

        var s = new Stack<Integer>();
        var list = new ArrayList<Integer>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                list.add(-1);
            } else if (!s.isEmpty() && s.peek() > arr[i]) {
                list.add(s.peek());
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                while (!s.isEmpty() && s.peek() < arr[i]) {
                    s.pop();
                    if (s.empty()) {
                        list.add(-1);
                    } else if (s.peek() > arr[i]) {
                        list.add(s.peek());
                    }
                }
            }
            s.push(arr[i]);
        }

        Collections.reverse(list);
        int[] newArr = list.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }

    }
}