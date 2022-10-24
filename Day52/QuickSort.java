package Day52;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; //取最后一个值作为pivot，然后将比它大的和比它小的换位置，然后再把pivot换回去
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,0,-8,7,12,5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
