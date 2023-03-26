package Day201;

import java.util.Arrays;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;

public class FindKthLargestNumber {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = randomArray(20, 10);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 5));
    }
}
