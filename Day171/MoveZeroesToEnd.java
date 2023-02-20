package Day171;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = randomArray(3,10);
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, left++, i);
            }
        }
    }
}
