package Day195;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> que;
    private int top;

    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        int size = que.size();
        que.offer(x);
        while (size-- > 0) {
            que.offer(que.poll());
        }
    }

    public int pop() {
        return que.poll();
    }

    public int top() {
        return que.peek();
    }
    public boolean empty() {
        return que.isEmpty();
    }
}
