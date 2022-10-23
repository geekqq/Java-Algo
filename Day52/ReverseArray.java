package Day52;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {1,4,-1,0,-8,12};
        System.out.println(Arrays.toString(reverseArr(nums)));
    }

    public static int[] reverseArr(int[] nums) {
        int n = nums.length;
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = nums[n - 1 - i];
        }
        return reverse;
    }
}
