import java.util.Stack;

public class StackWithSpace {
    public static void main(String[] args) 
    { 
        MyStack s = new MyStack(); 
        s.push(3); 
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.peek(); 
    } 
}

class MyStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MyStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int data) {
       int pushedData = stack.push(data);
       if(minStack.isEmpty()) {
           minStack.add(pushedData);
       }
       if(pushedData < minStack.peek() && !minStack.isEmpty()) {
            minStack.add(pushedData);
       }
       System.out.println(pushedData + " is pushed");
    }

    public void pop() {
        if(minStack.isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        int popedData = stack.pop();
        if(popedData == minStack.peek()) {
            minStack.pop();
        }
        System.out.println(popedData + " is poped");
    }

    public void getMin() {
        System.out.println(minStack.peek() + " is minimum");
    }

    
    public void peek() { 
        System.out.println(stack.peek()  + " is top");
    }
}