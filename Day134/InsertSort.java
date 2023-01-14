package Day134;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1,0,1,4,6,3,5,2,0};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insertSort(int[] nums) {
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
