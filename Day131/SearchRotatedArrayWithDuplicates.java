package Day131;

public class SearchRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,6,6,7,1,2,3,3};
        System.out.println(findTargetInRotatedArrayWithDuplicates(nums, 1));
    }
    public static boolean findTargetInRotatedArrayWithDuplicates(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == target) {
                return true;
            }
            if (nums[right] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
