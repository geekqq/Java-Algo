package Day269;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MergeSort {

    public static void mergeSort(int[] nums, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, temp, low, mid);
            mergeSort(nums, temp, mid + 1, high);
            merge(nums, temp, low, mid, high);
        }
    }

    private static void merge(int[] nums, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        printArray(arr);
    }
}
