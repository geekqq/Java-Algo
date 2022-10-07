package Day36;

import java.util.Arrays;

public class DemoInsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,3,0,1,9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] insertSort(int[] nums) {
        //corner case
        if (nums == null || nums.length <= 1) {
            return nums;
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
        return nums;
    }

    private static int[] swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return nums;
    }
}
