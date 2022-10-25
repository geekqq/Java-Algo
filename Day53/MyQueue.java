package Day53;

import java.util.Queue;
import java.util.Stack;

public class MyQueue<T> {
    //fields
    Stack<T> stackIn;
    Stack<T> stackOut;

    //method
    public MyQueue() {
        stackIn = new Stack<T>();
        stackOut = new Stack<T>();
    }

    public void offer(T val) {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        stackIn.push(val);
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
    }

    public T poll() {
        if (stackIn.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        return stackIn.pop();
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6};
        MyQueue q = new MyQueue();
        for (int k : keys) {
            q.offer(k);
        }
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

}
