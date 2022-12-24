package Day114;

import java.util.Arrays;

public class SearchForRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int left = leftPosition(nums, target);
        int right = rightPosition(nums, target);
        return new int[] {left, right};
    }
    private static int leftPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (left == nums.length || nums[left] != target) ? -1 : left;
    }
    private static int rightPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (right < 0 || nums[right] != target) ? -1 : right;
    }

    public static void main(String[] args) {
        int[] nums = null;
        int target = 2;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
