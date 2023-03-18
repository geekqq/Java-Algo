package Day195;

import java.util.Queue;
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
            System.out.println("UnderFlow!");
            System.exit(0);
        }
        var res = stackIn.pop();
        size--;
        return res;
    }

    public E peek() {
        if (stackIn.isEmpty()) {
            System.out.println("empty queue!");
            System.exit(0);
        }
        return stackIn.peek();
    }


    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 10; i++) {
            q.offer(i);
        }
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
    }
}
