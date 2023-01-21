package Day141;

import java.util.Arrays;

public class RotatedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3};
        int[] a = rotateArray(nums, 3);
        System.out.println(Arrays.toString(a));
    }

    private static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        return a;
    }
}
