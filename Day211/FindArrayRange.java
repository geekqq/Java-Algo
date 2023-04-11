package Day211;

import java.util.Arrays;

public class FindArrayRange {

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
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (target == nums[mid]) {
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
            if (target == nums[mid]) {
                index = mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,4,4,5,5,5};
        System.out.println(Arrays.toString(findArrayRange(nums, 4)));
        System.out.println(Arrays.toString(findArrayRange(nums, 5)));
        System.out.println(Arrays.toString(findArrayRange(nums, 1)));
        System.out.println(Arrays.toString(findArrayRange(nums, 0)));
    }
}
