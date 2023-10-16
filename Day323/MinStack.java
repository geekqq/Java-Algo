package Day323;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stackStr;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackStr = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        stackStr.push(val);
        if (stackMin.isEmpty() || stackMin.peek() >= val) stackMin.push(val);
        else stackMin.push(stackMin.peek());
    }

    public int top() {
        if (stackStr.isEmpty()) throw new EmptyStackException();
        return stackStr.peek();
    }

    public void pop() {
        if (stackStr.isEmpty()) throw new EmptyStackException();
        stackStr.pop();
        stackMin.pop();
    }

    public int getMin() {
        if (stackStr.isEmpty()) throw new EmptyStackException();
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
