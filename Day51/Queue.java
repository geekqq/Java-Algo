package Day51;

import java.util.Stack;

public class Queue<T> {
    private Stack<T> stackIn;
    private Stack<T> stackOut;

    //constructor
    public Queue() {
        stackIn = new Stack<T>();
        stackOut = new Stack<T>();
    }

    //offer
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

    public T peek() {
        if (stackIn.isEmpty()) {
            System.out.println("underflow!!");
            System.exit(0);
        }
        return stackOut.peek();
    }


    public static void main(String[] args) {
        int [] keys = {1,2,3,4,5};
        Queue<Integer> q = new Queue<>();
        for (int key : keys) {
            q.offer(key);
        }
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
