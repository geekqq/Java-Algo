package Day111;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }
        System.out.println("Elements of the queue: " + q);
        int removedEle = q.remove();
        System.out.println("Removed element: " + removedEle);
        System.out.println(q);
        int head = q.peek();
        System.out.println("Head of queue: " + head);
        int size = q.size();
        System.out.println("Size of queue: " + size
        );
    }
}
