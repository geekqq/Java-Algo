package Day111;

import java.util.Stack;

public class MyQueue<E> {
    private Stack<E> stackIn;
    private Stack<E> stackOut;
    int size;
    public MyQueue() {
        stackIn = new Stack<E>();
        stackOut = new Stack<E>();
        size = 0;
    }
    public void offer(E val) {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        stackIn.push(val);
        size++;
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
    }
    public E poll() {
        if (stackIn.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        return stackIn.pop();

    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 19; i++) {
            q.offer(i);
        }
        for (int i = 0; i < 111; i++) {
            System.out.print(q.poll() + " ");
        }
    }
}
