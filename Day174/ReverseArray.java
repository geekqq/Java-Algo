package Day174;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = randomArray(10,10);
        System.out.println(Arrays.toString(nums));
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
