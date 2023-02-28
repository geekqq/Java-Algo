package Day179;

import java.util.Arrays;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 12);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargestElement(nums, 2));
    }
    private static int findKthLargestElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
