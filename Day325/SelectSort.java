package Day325;

import static Day256.PrintArray.printArray;
import static Day324.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class SelectSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 4, 22);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}
