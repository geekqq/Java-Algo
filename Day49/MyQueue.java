package Day49;

import java.util.Queue;
import java.util.Stack;

public abstract class MyQueue implements Queue<Object> { //TODO: Generics
    //fields
    private Stack stackIn; //implemented by what, fields will be what
    private Stack stackOut;

    //methods
    //constructor
    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public void offer(int val) {
        stackIn.push(val);
    }

    public Object poll() {
        move();
        return stackOut.isEmpty() ? null : (Integer) stackOut.pop();
    }

    public Object peek() {
        move();
        return stackOut.isEmpty() ? null : stackOut.peek();
    }

    public void move() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
