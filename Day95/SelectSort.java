package Day95;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,3,2,5,6,3,7,8,7};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
