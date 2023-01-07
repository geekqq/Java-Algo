package Day128;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {3,4,5,5,1,0,7,4,6};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insertSort(int[] nums) {
        //cc
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
