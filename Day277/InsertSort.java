package Day277;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 100);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }
}
