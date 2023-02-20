package Day171;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Day138.RandomArray.randomArray;
import static Day171.FindKthLargestElement.reverseArrayInPlace;

public class findPeak {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        reverseArrayInPlace(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(findPeakIndex(nums));
    }

    private static int findPeakIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
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
        return Math.max(nums[left], nums[right]);
    }
}
