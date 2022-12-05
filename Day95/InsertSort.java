package Day95;

import java.util.Arrays;

public class InsertSort {
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

    public static void main(String[] args) {
        int[] nums = {3,3,2,5,6,3,7,8,7};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
