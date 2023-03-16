package Day192;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class FindPeakIndex {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(findPeakIndex(nums));
    }

    public static int findPeakIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > 0 && nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }
}
