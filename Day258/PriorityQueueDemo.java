package Day258;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static int findSecondMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // initiate a queue reversed,max on the top
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int max = pq.poll();
        while (pq.peek() == max) {
            pq.poll();
        }
        return pq.peek();
    }

    public static int findSecondMaxI(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 4, 0, 5,2, 5, -2};
        System.out.println(findSecondMax(nums));
        System.out.println(findSecondMaxI(nums));
    }
}
