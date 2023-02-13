package Day165;

import Day11.ArrayRank;

import java.util.Arrays;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 3));
        System.out.println(findKthLargestElementII(nums, 3));
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int pivot = nums[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index, end);
        if (index == k) return nums[index];
        else if (index < k) return quickSelect(nums, index + 1, end, k);
        else return quickSelect(nums, 0, index - 1, k);
    }

    private static int findKthLargestElementII(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
