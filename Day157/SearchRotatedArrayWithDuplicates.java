package Day157;

public class SearchRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {7,7,7,8,9,9,10,1,2,3,4,5,6};
        for (int i = 0; i < 12; i++) {
            System.out.println(i + " = " + searchRotatedArrayWithDuplicates(nums, i));
        }
    }

    private static boolean searchRotatedArrayWithDuplicates(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return true;
            if (nums[right] == target) return true;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
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
}
