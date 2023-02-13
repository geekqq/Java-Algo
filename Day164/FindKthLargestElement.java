package Day164;

import java.util.Arrays;
import java.util.PriorityQueue;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class FindKthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;

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

    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 4));
        System.out.println(getKthLargest(nums, 4));
    }

    private static int getKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> res = new PriorityQueue<>(k);
        for (int num : nums) {
            res.offer(num);
            if (res.size() > k) {
                res.poll();
            }
        }
        return res.peek();
    }
}
