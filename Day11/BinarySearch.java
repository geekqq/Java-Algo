package Day11;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 19;
        System.out.println(getIndexOfTarget(nums, target));
    }

    public static int getIndexOfTarget(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return -1;
        //binary search
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
