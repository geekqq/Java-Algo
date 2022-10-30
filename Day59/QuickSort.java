package Day59;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {-1};
        int[] nums2 = {2,1,3,4,5,4,6,-4};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        quickSort(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums2));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < nums.length - 1; j++) {
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
}
