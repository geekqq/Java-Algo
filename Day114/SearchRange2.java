package Day114;

import java.util.Arrays;

public class SearchRange2 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];
        result[0] = leftIndex(nums, target);
        result[1] = rightIndex(nums, target);
        return result;
    }
    private static int leftIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    private static int rightIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,5,6,6,7,8,8,8,9,9,10};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
