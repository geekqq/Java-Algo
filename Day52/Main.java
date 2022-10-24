package Day52;

import java.util.LinkedList;
import java.util.Queue;
//print queue elements
public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);

        System.out.println("Queue elements:");
        for (int item : q) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
