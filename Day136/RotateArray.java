package Day136;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(rotateArray(nums, 5)));
    }

    private static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        return newArr;
    }
}
