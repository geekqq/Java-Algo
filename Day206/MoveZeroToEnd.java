package Day206;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class MoveZeroToEnd {

    public static void moveZero(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zero++, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(4, 10);
        System.out.println(Arrays.toString(nums));
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }
}
