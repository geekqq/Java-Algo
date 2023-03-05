package Day184;

public class FindTargetInRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,6,6,7,1,1,2,3};
        for (int i = 0; i < 15; i++) {
            System.out.println(i + " = " + findTargetInRotatedArrayWithDuplicates(nums, i));
        }
    }

    public static boolean findTargetInRotatedArrayWithDuplicates(int[] nums, int x) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) return true;
            if (nums[left] == x) return true;
            if (nums[right] == x) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[left]) {
                if (x > nums[left] && x < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (x > nums[mid] && x < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
