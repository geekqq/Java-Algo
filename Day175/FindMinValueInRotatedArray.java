package Day175;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,0,1,2,3};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
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
