package Day129;

public class SearchRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,6,6,7,7,1,1,1,2,3,3};
        int target = 4;
    }

    public static boolean findTargetInRotatedArrayWithDuplicates(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return true;
            if (nums[right] == target) return true;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
