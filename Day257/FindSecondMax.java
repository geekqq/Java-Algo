package Day257;

import java.util.Collections;
import java.util.PriorityQueue;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day257.FindDuplicates.findDuplicates;

public class FindSecondMax {

    public static int findSecondMax(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("invalid input");
        }
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

    public static int findSecondMaxII(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int max = pq.poll();
        while (pq.peek() == max) {
            pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = randomArray(10, 20);
        int[] arr = {13, 34, 2, 34 ,33 ,1};
        printArray(nums);

        System.out.println(findSecondMax(arr));
        System.out.println(findSecondMaxII(arr));
        findDuplicates(nums);
    }
}
