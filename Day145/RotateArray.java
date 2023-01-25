package Day145;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,9};
        rotateArray(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
    private static void rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
