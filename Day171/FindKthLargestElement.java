package Day171;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        reverseArrayInPlace(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums,5));
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
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
    private static int[] reverseArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] newArr = new int[nums.length];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            newArr[j++] = nums[i];
        }
        return newArr;
    }

    public static void reverseArrayInPlace(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

}
