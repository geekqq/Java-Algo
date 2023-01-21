package Day141;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = randomArray(2, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(moveZeros(nums)));
    }

    private static int[] moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 1) left++;
            else if (nums[right] == 0) right--;
            else swap(nums, left,right);
        }
        return nums;
    }
}
