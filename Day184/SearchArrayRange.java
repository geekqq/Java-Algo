package Day184;

import java.util.Arrays;

public class SearchArrayRange {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 2, 3,3,3,4,5,5,5,6,7};
        System.out.println(Arrays.toString(searchArrayRange(nums, 2)));
    }

    public static int[] searchArrayRange(int[] nums, int x) {
        int[] res = new int[2];
        res[0] = findLeftIndex(nums, x);
        res[1] = findRightIndex(nums, x);
        return res;
    }

    private static int findLeftIndex(int[] nums, int x) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == x) {
                index = mid;
            }
        }
        return index;
    }

    private static int findRightIndex(int[] nums, int x) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == x) {
                index = mid;
            }
        }
        return index;
    }
}
