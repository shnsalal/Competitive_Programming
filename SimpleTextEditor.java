// Implement a simple text editor. The editor initially contains an empty string, . 
// Perform  operations of the following  types:

// append - Append string  to the end of .
// delete - Delete the last  characters of .
// print - Print the  character of .
// undo - Undo the last (not previously undone) operation of type  or , 
// reverting  to the state it was in prior to that operation.

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    static Stack<String> prevStack = new Stack<>();
    static String res = "abcde";

    public static void main(String[] args) {

        // Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // String[] arr = new String[n];

        // for (int i = 0; i < n; i++) {
        // arr[i] = scan.next();
        // }

        String[] arr = { "1 fg", "3 6", "2 5", "4", "3 7", "4", "3 4" };
        // String[] arr = { "1 abc", "3 3", "2 3", "1 xy", "3 2", "4", "4", "3 1" };
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (!arr[i].contains(" ")) {
                undo();
            } else {
                String[] str = arr[i].split(" ");
                int key = Integer.parseInt(str[0]);
                if (key == 1) {
                    append(str[1]);
                } else if (key == 2) {
                    delete(str[1]);
                } else if (key == 3) {
                    print(str[1]);
                }
            }

        }

    }

    public static void append(String str) {
        prevStack.push(res);
        res += str;
    }

    public static void delete(String str) {
        prevStack.push(res);
        int n = Integer.parseInt(str);
        if (res.length() - n >= 0) {
            res = res.substring(0, res.length() - n);
        }
    }

    public static void print(String str) {
        int n = Integer.parseInt(str);
        System.out.println(res.charAt(n - 1));
    }

    public static void undo() {
        if (!prevStack.isEmpty()) {
            res = prevStack.pop();
        }
    }
}
