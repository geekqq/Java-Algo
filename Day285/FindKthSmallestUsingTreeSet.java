package Day285;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class FindKthSmallestUsingTreeSet {

    public static int findKthSmallest(int[] arr1, int[] arr2, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            set.add(i);
        }
        for (int i = 0; i < k - 1; i++) {
            set.pollFirst();
        }
        return set.first();
    }

    public static int findKthSmallestMinHeap(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++) {
            pq.offer(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            pq.offer(arr2[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int[] arr3 = {100, 112, 256, 349, 770};
        int[] arr4 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(findKthSmallest(arr1, arr2, 7));
        System.out.println(findKthSmallest(arr3, arr4, 7));
        System.out.println(findKthSmallestMinHeap(arr1, arr2, 7));
        System.out.println(findKthSmallestMinHeap(arr3, arr4, 7));
    }
}
