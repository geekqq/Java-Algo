package Day153;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,0,1,2};
        System.out.println(fingMinValue(nums));
    }

    private static int fingMinValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
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
