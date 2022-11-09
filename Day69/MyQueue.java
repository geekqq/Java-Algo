package Day69;

import java.util.Stack;

public class MyQueue<E> {
    private Stack<E> stackIn;
    private Stack<E> stackOut;

    public MyQueue() {
        stackIn = new Stack<E>();
        stackOut = new Stack<E>();
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
        while (stackIn.isEmpty()) {
            System.out.println("Underflow!");
            System.exit(0);
        }
        return stackIn.pop();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        MyQueue q = new MyQueue();
        for (int i : nums) {
            q.offer(i);
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
        System.out.println(q.poll());
    }
}
