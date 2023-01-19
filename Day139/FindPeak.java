package Day139;

public class FindPeak {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,-4,0,2};
        System.out.println(findPeak(nums));
    }

    private static int findPeak(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (mid - 1 >= 0 && nums[mid] > nums[mid - 1]) left = mid;
            else right = mid;
        }
        return nums[left] > nums[right] ? left : right;
    }
}
