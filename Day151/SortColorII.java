package Day151;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class SortColorII {
    public static void main(String[] args) {
        int[] color = randomArray(3,10);
        System.out.println(Arrays.toString(color));
        sortColor(color);
        System.out.println(Arrays.toString(color));
    }
    private static void sortColor(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }
    }
}
