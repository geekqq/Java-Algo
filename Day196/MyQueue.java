package Day196;

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
        if (stackIn.isEmpty()) {
            System.out.println("Underflow!");
            System.exit(0);
        }
        return stackIn.pop();
    }

    public E peek() {
        if (stackIn.isEmpty()) {
            System.out.println("empty queue");
            System.exit(0);
        }
        return stackIn.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 10; i++) {
            q.offer(i);
        }
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());
        q.offer(q.poll());

    }
}
