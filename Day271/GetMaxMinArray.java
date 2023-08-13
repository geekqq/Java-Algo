package Day271;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day256.RandomArray.selectSort;

public class GetMaxMinArray {
    //the input arr is sorted
    public static void getMaxMinArray(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int max = arr[maxIdx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(8, 18);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
        getMaxMinArray(arr);
        printArray(arr);
    }
}
