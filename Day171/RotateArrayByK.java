package Day171;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class RotateArrayByK {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(rotateArrayByK(nums, 3)));
    }

    private static int[] rotateArrayByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        return newArr;
    }
}
