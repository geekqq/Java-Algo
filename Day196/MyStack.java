package Day196;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> que;
    int top;

    public MyStack() {
        que = new LinkedList();
    }

    public void push(int val) {
        int size = que.size();
        que.offer(val);
        while (size-- > 0) {
            que.offer(que.poll());
        }
    }

    public int pop() {
        return que.poll();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
