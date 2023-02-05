package Day156;

import java.util.Arrays;

public class SearchRangeArray {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,6,7,7,8,8,9,9};
        System.out.println(Arrays.toString(searchArrayRange(nums, 1)));
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
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private static int findRightIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}
