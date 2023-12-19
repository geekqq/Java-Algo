package Day328;

import static Day256.PrintArray.printArray;
import static Day324.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = low;
        int pivot = arr[high];
        while (i <= high) {
            if (arr[i] <= pivot) {
                swap(arr, i++, j++);
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 5, 25);
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
