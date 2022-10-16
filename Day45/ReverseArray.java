package Day45;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {0,-1,2,3,5,3,4};
        System.out.println(Arrays.toString(reverseArray(nums)));
        System.out.println(Arrays.toString(swapArray(nums)));
    }

    public static int[] reverseArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] reverse = new int[nums.length];
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            reverse[j--] = nums[i];
        }
        return reverse;
    }

    public static int[] swapArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 -i] = temp;
        }
        return nums;
    }
}
