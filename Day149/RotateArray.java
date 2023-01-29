package Day149;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        rotateArray(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }
    }
}
