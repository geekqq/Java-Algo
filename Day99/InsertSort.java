package Day99;

import java.util.ArrayList;
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
        int[] nums = {20,20,40,30,10,30,50,40};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
