package Day129;

import java.util.Arrays;

public class SearchArray {
    public static void main(String[] args) {
        int[] nums = {1,3,4,4,4,4,5,5,5,6,6};
        int target = 2;
        System.out.println(Arrays.toString(findArrayRange(nums, target)));
    }
    public static int[] findArrayRange(int[] nums, int target) {
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
    private static int findRightIndex(int[] nums, int target) {
        int index = -1 ;
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
