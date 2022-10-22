package Day51;

import java.util.Queue;
import java.util.Stack;

public abstract class MyQueue implements Queue { //TODO: Generics
    //fields
    private Stack stackIn;
    private Stack stackOut;

    //methods
    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public void offer(int val) {
        stackIn.push(val);
    }

    public Object poll() {
        move();
        return stackOut.isEmpty() ? null : stackOut.pop();
    }

    @Override
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
