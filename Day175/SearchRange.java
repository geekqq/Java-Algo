package Day175;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {11,22,33,33,33,44,44,55,66};
        System.out.println(Arrays.toString(searchArrayRange(nums, 33)));
    }

    private static int[] searchArrayRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeftIndex(nums, target);
        res[1] = findRightIndex(nums, target);
        return res;
    }

    private static int findLeftIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left);
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

    private static int findRightIndex(int[] nums, int target) {
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
}
