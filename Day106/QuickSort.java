package Day106;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1,4,1,2,7,5,9};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < arr.length - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
