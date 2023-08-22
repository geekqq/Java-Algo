package Day278;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class QuickSort {


    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (i <= high) {
            if (arr[i] <= pivot) {
                swap(arr, i++, j++);
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 36);
        printArray(arr);
        sort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
