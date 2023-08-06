package Day266;

public class MaxPriorityQueue {

    Integer[] heap;
    int n;  //size of max heap

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

    public void insert(int x) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            swap(heap, k / 2, k);
            k = k / 2;
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int deleteMax() {
        int max = heap[1];
        swap(heap, 1, n);
        heap[n--] = null;
        sink(1);
        //heap[n + 1] = null;
        if (n > 0 && (n == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k; // left child
            if (j < n && heap[j] < heap[j + 1]) { // j < n is to check if has a right child
                j++;
            }
            if (heap[k] > heap[j]) break;
            swap(heap, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPriorityQueue pq = new MaxPriorityQueue(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
        pq.insert(4);
        pq.insert(1);
        pq.insert(3);
        pq.insert(8);
        pq.insert(5);
        pq.insert(9);
        System.out.println(pq.size());
        pq.printMaxHeap();
        System.out.println(pq.deleteMax());
        pq.printMaxHeap();
    }
}
