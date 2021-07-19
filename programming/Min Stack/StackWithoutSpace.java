public class StackWithoutSpace {
    public static void main(String[] args) {
        MyStack1 s = new MyStack1();
        System.out.println("push: " + s.push(3));
        System.out.println("push: " + s.push(5));
        System.out.println("min: " + s.getMin());
        System.out.println("push: " + s.push(2));
        System.out.println("push: " + s.push(1));
        System.out.println("min: " + s.getMin());
        System.out.println("pop: " + s.pop());
        System.out.println("min: " + s.getMin());
        System.out.println("pop: " + s.pop());
        System.out.println("peek: " + s.peek()); 
        System.out.println("min: " + s.getMin());
    }
}

class MyStack1 {
    int top;
    int[] arr;
    int min = Integer.MAX_VALUE;
    final static int CAPACITY = 5;
    public MyStack1 () {
        top = -1;
        arr = new int[CAPACITY];
    }

    public int push(int data) {
        if(top == CAPACITY) {
            return -1;
        }
        if(top == -1) {
            arr[++top] = data;
            min = arr[top];
        } else if(data >= min) {
            arr[++top] = data;
        } else {
            arr[++top] = 2 * data - min;
            min = data;
        }
        return data;
    }

    public int pop() {
        int returnValue = -1;
        if(top == -1) {
            return -1;
        }
        if(arr[top] < min) {
            returnValue = min;
            min = 2 * min - arr[top];
        }
        arr[top--] = Integer.MIN_VALUE;
        return returnValue;
    }

    public int getMin() {
        if(top == -1 || top == CAPACITY) {
            return -1;
        }
        return min;
    }

    public int peek() {
        if(top == -1 || top == CAPACITY) {
            return -1;
        }
        return arr[0];
    }
}
