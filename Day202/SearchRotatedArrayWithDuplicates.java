package Day202;

public class SearchRotatedArrayWithDuplicates {
    public static boolean searchTargetInRotatedArrayWithDuplicates(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return true;
            if (nums[mid] == target) return true;
            if (nums[right] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[left] < nums[mid]) {
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

    public static void main(String[] args) {
        int[] nums = {5,5,7,0,0,1,2,2,3};
        for (int i = 0; i < 12; i++) {
            System.out.println(i + " = " + searchTargetInRotatedArrayWithDuplicates(nums, i));
        }
    }
}
