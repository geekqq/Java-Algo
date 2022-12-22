package Day111;

import java.util.*;

public class MyPriorityQueue {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>();
        pq.add("Geeks0");
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks1");
        pq.add("Stone");
        pq.add("Hoo");
        System.out.println(pq);
        pq.remove("Geeks");
        System.out.println("After remove: " + pq);
        System.out.println("Poll method: " + pq.poll());
        System.out.println("Final queue: " + pq);
        Iterator iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
