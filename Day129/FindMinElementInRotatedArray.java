package Day129;

public class FindMinElementInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,1,2};
        System.out.println(findMinInRotatedArray(nums));
    }
    public static int findMinInRotatedArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
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
        return Math.min(nums[left], nums[right]);
    }
}
