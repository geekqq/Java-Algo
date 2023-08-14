package Day272;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class SquaredSortedArray {

    public static int[] squareSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] newArr = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        for (int k = arr.length - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                newArr[k] = arr[i] * arr[i];
                i++;
            } else {
                newArr[k] = arr[j] * arr[j];
                j--;
            }
        }
        return newArr;
    }

    public static void insertSort(int[] arr) {
        //cc
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp <arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = randomArray(10, 10);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
        int[] nums = {-11, -1, 0, 2, 10};
        int[] newArr = squareSortedArray(nums);
        printArray(newArr);
    }
}
