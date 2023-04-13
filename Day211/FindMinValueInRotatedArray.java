package Day211;

public class FindMinValueInRotatedArray {

    public static int findMinValue(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1};
        System.out.println(findMinValue(nums));
    }
}