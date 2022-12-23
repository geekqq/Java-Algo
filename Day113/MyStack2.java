package Day113;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack2 {
    static Queue<Integer> q = new LinkedList<>();
    void push(int x) {
        int s = q.size();
        q.add(x);
        for (int i = 0; i < s; i++) {
            q.add(q.remove());
        }
    }
    void pop() {
        if (q.isEmpty()) {
            return;
        }
        q.remove();
    }
    static int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }
    int size() {
        return q.size();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(23);
        s.push(12);
        System.out.println("current size: " + s.size());
        //System.out.println(s.top());
        //System.out.println(s.top());
        //System.out.println(s.top());
    }
}
