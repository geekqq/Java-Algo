package Day144;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,-1,0,2,3};
        System.out.println(findMinValue(nums));
    }

    private static int findMinValue(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
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
        return Math.min(nums[left], nums[right]);
    }
}

