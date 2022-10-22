package Day51;

import java.util.Stack;

public class MinStack {
    //push, pop, peek, min
    //fields
    private Stack<Integer> stackEle;
    private Stack<Integer> stackMin;  //用来记录当前stack的最小值

    //methods
    public MinStack() {
        stackEle = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int val) {
        stackEle.push(val);
        if (stackMin.isEmpty() || stackMin.peek() >= val) {
            stackMin.push(val);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public Integer pop() {
        if (stackEle.isEmpty()) {
            return null;
        }
        stackMin.pop();
        return stackEle.pop();
    }

    public Integer top() {
        if (stackEle.isEmpty()) {
            return null;
        }
        return stackEle.peek();
    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            return null;
        }
        return stackMin.peek();
    }
}
