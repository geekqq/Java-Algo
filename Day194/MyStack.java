package Day194;

import java.util.LinkedList;
import java.util.Queue;
public class MyStack {

    private Queue<Integer> q;
    private int top;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int val) {
        int size = q.size();
        q.offer(val);
        while (size-- > 0) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 1; i < 13; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
    }
}
