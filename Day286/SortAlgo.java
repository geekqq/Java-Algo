package Day286;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class SortAlgo {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                    swap = false;
                }
            }
            if (swap) break;
        }
    }

    public static void selectSort(int[] arr) {
        //cc
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >=0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

    }

    public static int[] countSort(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);
        int len = Arrays.stream(res).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int value : res) {
            bucket[value]++;
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                res[index++] = i;
                bucket[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        int[] res = countSort(arr);
        //insertSort(arr);
//        selectSort(arr);
//        bubbleSort(arr);

        printArray(res);
    }
}
