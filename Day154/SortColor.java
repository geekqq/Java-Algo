package Day154;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class SortColor {
    public static void main(String[] args) {
        int[] color = randomArray(3,10);
        System.out.println(Arrays.toString(color));
        sortColorII(color);
        System.out.println(Arrays.toString(color));
    }

    private static void sortColor(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < right; i++) {
            if (nums[i] == 0) swap(nums, left++, i);
            else if (nums[i] == 2) swap(nums, right--, i--);
        }
    }

    private static void sortColorII(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }
}
