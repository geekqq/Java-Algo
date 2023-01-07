package Day128;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,0,1,2,3,4};
        int target = 4;
        System.out.println(findMinIndex(nums));
        System.out.println(searchInRotatedArray(nums, target));
    }
    public static int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
    public static int searchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 1) return -1;
        int left = 0;
        int right = nums.length - 1;
        int start = findMinIndex(nums);
        if (nums[start] <= target && target <= nums[right]) {
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
