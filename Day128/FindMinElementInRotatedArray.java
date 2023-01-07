package Day128;

public class FindMinElementInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,0,1,2};
    }
    private static int findMinValueInRotatedArray(int[] nums) {
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
