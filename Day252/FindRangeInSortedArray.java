package Day252;

import java.util.Arrays;

public class FindRangeInSortedArray {

    public static int[] searchRange(int[] nums, int t) {
        int[] res = new int[2];
        int n = nums.length;
        res[0] = findLeftIndex(nums, t);
        res[1] = findRightIndex(nums, t);
        return res;
    }
    private static int findLeftIndex(int[] nums, int t) {
        int leftIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == t) {
                leftIndex = mid;
            }
        }
        return leftIndex;
    }
    private static int findRightIndex(int[] nums, int t) {
        int rightIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == t) {
                rightIndex = mid;
            }
        }
        return rightIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(Arrays.toString(searchRange(nums, 7)));
    }
}
