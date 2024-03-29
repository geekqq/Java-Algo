package Day133;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,-4,0,2};
        System.out.println(findMinElement(nums));
    }

    public static int findMinElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
