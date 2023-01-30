package Day151;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class SortColor {
    public static void main(String[] args) {
        int[] color = randomArray(3, 6);
        System.out.println(Arrays.toString(color));
        sortColor(color);
        System.out.println(Arrays.toString(color));
    }

    private static void sortColor(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < right; i++) {
            if (nums[i] == 0) {
                swap(nums, left++, i);
            } else if (nums[i] == 2) {
                swap(nums, right--, i--);
            }
        }
    }
}
