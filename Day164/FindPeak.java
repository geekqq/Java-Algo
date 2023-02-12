package Day164;

public class FindPeak {
    public static void main(String[] args) {
        int[] nums = {1,4,6,2,3,0,5};
        System.out.println(findPeakIndex(nums));
    }

    private static int findPeakIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid > 0 && nums[mid] > nums[mid - 1]) {
                left = mid ;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }
}
