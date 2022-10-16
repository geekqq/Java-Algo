package Day45;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,4,2,6,4,8,9,10};
        mergeSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr, int len) {
        if (len < 2) return;
        int leftArrLen = len / 2;
        int rightArrLen = len - len / 2;

        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        //copy the data to both subarrays
        for (int i = 0; i < leftArrLen; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = 0; i < rightArrLen; i++) {
            rightArr[i] = arr[rightArrLen + i];
        }
//        System.out.println(Arrays.toString(leftArr));
//        System.out.println(Arrays.toString(rightArr));
        mergeSort(leftArr, leftArrLen);
        mergeSort(rightArr, rightArrLen);
        merge(arr, leftArr, rightArr, leftArrLen, rightArrLen);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftLen, int rightLen) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftLen) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            arr[k++] = rightArr[j++];
        }
    }
}
