package Day118;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,10,0,1,2,3};
        int target = 3;
        System.out.println(searchRotatedArray(nums, target));
    }

    private static int findMinIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private static int searchRotatedArray(int[] nums, int target) {
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
}
