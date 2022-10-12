package Day39;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {5,23,6,4,-2,7,0};
        int t = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(binarySearch(nums, t));
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
