package Day170;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5,6};
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
