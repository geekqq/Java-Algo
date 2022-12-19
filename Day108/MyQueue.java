package Day108;

import java.util.Stack;

public class MyQueue<E> {
    private Stack<E> stackIn;
    private Stack<E> stackOut;
    public MyQueue(){
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
            System.out.println("UnderFlow!!");
            System.exit(0);
        }
        return stackIn.pop();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 11; i++) {
            q.offer(i);
        }
        for (int i = 0; i < 12; i++) {
            System.out.print(q.poll() + " ");
        }
    }
}
