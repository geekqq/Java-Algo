package Day156;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class MinAndMaxValueInArray {
    public static void main(String[] args) {
        int[] nums = randomArray(12,10);
        System.out.println(Arrays.toString(nums));
        System.out.println(findMinInArray(nums));
        System.out.println(findMaxInArray(nums));
    }

    private static int findMinInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    private static int findMaxInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
