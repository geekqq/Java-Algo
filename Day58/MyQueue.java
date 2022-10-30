package Day58;

import java.util.Stack;

public class MyQueue<E> {
    //fields
    private Stack<E> stackIn;
    private Stack<E> stackOut;

    //constructor
    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public void offer(E val) {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        stackIn.push(val);
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
    }

    public E poll() {
        if (stackIn.isEmpty()) {
            System.out.println("underflow!!");
            System.exit(0);
        }
        return stackIn.pop();
    }

    public E peek() {
        if (stackIn.isEmpty()) {
            System.out.println("underflow!!");
            System.exit(0);
        }
        return stackIn.peek();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        int[] nums = {12,423,34,5,-5,0,6};
        for (int n : nums) {
            q.offer(n);
        }
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
