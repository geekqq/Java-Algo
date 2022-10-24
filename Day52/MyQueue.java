package Day52;

import java.util.Queue;
import java.util.Stack;

public class MyQueue <T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(T val) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T poll() {
        if (stack1.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        return stack1.pop();
    }

    public T top() {
        if (stack1.isEmpty()) {
            System.out.println("It is empty");
            System.exit(0);
        }
        return stack1.peek();
    }


    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6,7,8,9};
        MyQueue q = new MyQueue();
        for (int key : keys) {
            q.offer(key);
        }

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
