package Day266;

public class MaxPriorityQueue {

    Integer[] heap;
    int n;

    public MaxPriorityQueue(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        MaxPriorityQueue pq = new MaxPriorityQueue(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
    }
}
