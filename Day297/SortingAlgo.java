package Day297;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class SortingAlgo {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+ 1]) {
                    swap(arr, j, j + 1);
                    swap =false;
                }
            }
            if (swap) break;
        }
    }


    public static void selectSort(int[] arr) {
        //cc
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

    public static void insertSort(int[] arr) {
        //cc
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


    public static int[] countSort(int[] arr) {
        //cc
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int len = Arrays.stream(newArr).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int i : newArr) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                newArr[index++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        System.out.println("====bubble====");
        int[] arr = randomArray(10, 20);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);

        System.out.println("====select====");
        int[] arr1 = randomArray(10, 20);
        printArray(arr1);
        selectSort(arr1);
        printArray(arr1);

        System.out.println("====insert====");
        int[] arr2 = randomArray(10, 20);
        printArray(arr2);
        insertSort(arr2);
        printArray(arr2);

        System.out.println("====count====");
        int[] arr3 = randomArray(10, 20);
        printArray(arr3);
        int[] res = countSort(arr3);
        printArray(res);
    }
}
