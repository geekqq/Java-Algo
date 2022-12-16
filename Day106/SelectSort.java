package Day106;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1,4,1,2,7,5,9};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}
