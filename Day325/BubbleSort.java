package Day325;

import static Day256.PrintArray.printArray;
import static Day324.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = false;
                }
            }
            if (isSwap) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 4, 19);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
