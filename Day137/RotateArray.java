package Day137;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        rotateArray(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
    private static void rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = newArr[i];
        }
    }
}
