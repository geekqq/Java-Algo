package Day161;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = randomArray(3,12);
        System.out.println(Arrays.toString(nums));
        moreZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moreZeroesToEnd(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zero++, i);
            }
        }
    }
}
