package Day123;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,0,1};
        int target = 5;
        System.out.println(searchRotatedArray(nums,target));
    }
    public static int searchRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = findMinIndex(nums);
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

    public static int findMinIndex(int[] nums) {
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
}
