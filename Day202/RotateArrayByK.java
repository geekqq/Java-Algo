package Day202;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class RotateArrayByK {

    public static int[] rotatedArrayByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(15, 10);
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(rotatedArrayByK(nums, 5)));
    }
}
