package Day121;

import java.util.Arrays;

public class SearchArray {
    //search first and last index in sorted array
    public static int[] searchArray(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeftIndex(nums, target);
        res[1] = findRightIndex(nums, target);
        return res;
    }
    public static int findLeftIndex(int[] nums, int target) {
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
    public static  int findRightIndex(int[] nums, int target) {
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
        int[] nums = {1,2,2,3,3,4};
        int target = 3;
        System.out.println(Arrays.toString(searchArray(nums, target)));
    }
}
