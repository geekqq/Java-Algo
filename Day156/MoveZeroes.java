package Day156;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] zeroArray = randomArray(3, 12);
        System.out.println(Arrays.toString(zeroArray));
        moveZeroes(zeroArray);
        System.out.println(Arrays.toString(zeroArray));

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
