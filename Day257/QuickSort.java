package Day257;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class QuickSort {

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
    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 5, 25);
        printArray(nums);
        sort(nums, 0, nums.length - 1);
        printArray(nums);
    }
}
