package Day127;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        System.out.println(findMinIndex(nums));
        System.out.println(searchRotatedArray(nums, 9));
    }

    //find min index in rotated array
    public static int findMinIndex(int[] nums) {
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
    public static int searchRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
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
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
