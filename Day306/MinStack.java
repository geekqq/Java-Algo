package Day306;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stackStr;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackStr = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int val) {
        stackStr.push(val);
        if (stackMin.isEmpty() || stackMin.peek() > val) stackMin.push(val);
        else stackMin.push(stackMin.peek());
    }

    public int top() {
        return stackStr.peek();
    }

    public void pop() {
        if (stackStr.isEmpty()) throw new EmptyStackException();
        stackMin.pop();
        stackStr.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Day305.MinStack minStack = new Day305.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
