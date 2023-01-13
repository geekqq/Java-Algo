package Day133;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1,0,1,4,3,5,2,0};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
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
    private static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }
}
