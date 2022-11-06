package Day66;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, -3, 1, 8, -3, 0, 90, 90};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums1 = {12};
        insertSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int key = 0;
        for (int i = 1; i < nums.length; i++) {
            key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}
