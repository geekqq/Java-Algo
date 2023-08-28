package Day281;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = false;
                }
            }
            if (swap) break;
        }
    }



    public static void main(String[] args) {
        int[] arr = randomArray(100, 200);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
