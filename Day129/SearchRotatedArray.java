package Day129;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9,1,2,3,4};
        System.out.println(findTargetInRotatedArray(nums, 1));
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " = " + findTargetInRotatedArray(nums, i));
        }
    }
    public static int findTargetInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = findMinIndex(nums);
        int left = 0;
        int right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
