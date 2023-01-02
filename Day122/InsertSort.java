package Day122;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1,4,2,7,2,0,9};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}
