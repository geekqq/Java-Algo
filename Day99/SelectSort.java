package Day99;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class SelectSort {
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int minIndex;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = {20,20,40,30,10,30,50,40};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
