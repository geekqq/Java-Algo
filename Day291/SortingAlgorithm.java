package Day291;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class SortingAlgorithm {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
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
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
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

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
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


    public static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high ; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= mid) {
            arr[k++] = temp[j++];
        }
    }

    public static void colorSort(int[] arr) {
        //arr
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i++, j++);
            } else if (arr[i] == 1) i++;
            else if (arr[i] == 2) swap(arr, i, k--);
        }
    }
    public static void main(String[] args) {
        int[] arr = randomArray(10, 2);
        printArray(arr);
        //bubbleSort(arr);
        //selectSort(arr);
        //insertSort(arr);
        //int[] sorted = countSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        //mergeSort(arr, new int[arr.length],0, arr.length - 1);
        colorSort(arr);
        printArray(arr);
        //printArray(sorted);
    }
}
