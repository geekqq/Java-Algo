package Day39;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {4,6,2,-1,0,7,5};
        System.out.println(Arrays.toString(selectSort(nums)));
    }

    public static int[] selectSort(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }
    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
