package Day265;

import static Day256.PrintArray.printArray;
import static Day265.generateRandomArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class MergeSort {

    public static void mergeSort(int[] nums, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, temp, low, mid);
            mergeSort(nums, temp, mid + 1, high);
            merge(nums, temp, low, mid, high);
        }
    }
    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high ; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid  && j <= high) {
            if (temp[i] < temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = generateArrayWithoutDuplicates(10, 3, 19);
        printArray(nums);
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        printArray(nums);
    }
}
