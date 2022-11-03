package Day63;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, -3, 1, 8, -3, 0, 90, 90};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < nums.length - 1 ; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, j, i);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }
}
