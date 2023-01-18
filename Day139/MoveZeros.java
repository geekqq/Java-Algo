package Day139;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = randomArray(2, 10);
        System.out.println(Arrays.toString(nums));
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));

    }
    private static void moveZeros(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int left = 0;
        int right =nums.length - 1;
        while (left <= right) {
            if (nums[left] == 1) left++;
            else if (nums[right] == 0) right--;
            else {
                swap(nums, right, left);
            }
        }
    }
}
