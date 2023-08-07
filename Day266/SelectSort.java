package Day266;

import static Day37.SortedArray.swap;

public class SelectSort {

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = j;
                }
                swap(nums, i, min);
            }
        }
    }
}
