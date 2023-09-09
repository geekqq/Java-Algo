package Day290;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class MergeSort {

    public static void sort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high ; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= high) {
            arr[k++] = temp[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        sort(arr, new int[arr.length], 0, arr.length - 1);
        printArray(arr);
    }
}