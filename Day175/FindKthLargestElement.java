package Day175;

import java.util.Arrays;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 3));
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw  new IllegalArgumentException();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
