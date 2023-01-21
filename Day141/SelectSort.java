package Day141;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = randomArray(101, 10);
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
