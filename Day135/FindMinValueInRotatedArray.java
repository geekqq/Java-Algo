package Day135;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,-4,0,2};
        System.out.println(findMinValInRotatedArray(nums));
    }
    private static int findMinValInRotatedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
