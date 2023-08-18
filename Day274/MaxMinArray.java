package Day274;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxMinArray {

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

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
        getMaxMinArray(arr);
        printArray(arr);
    }
}
