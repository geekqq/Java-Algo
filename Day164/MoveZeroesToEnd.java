package Day164;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 1, 1, 2, 2, 0, 2, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zero++, i);
            }
        }
    }
}
