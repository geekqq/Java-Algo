package Day266;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return arr2;
        if (arr2 == null || arr2.length == 0) return arr1;
        int i = 0;
        int j = 0;
        int k = 0;
        int m = arr1.length;
        int n = arr2.length;
        int[] newArr = new int[m + n];
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                newArr[k++] = arr1[i++];
            } else {
                newArr[k++] = arr2[j++];
            }
        }
        while (i < m) {
            newArr[k++] = arr1[i++];
        }
        while (j < n) {
            newArr[k++] = arr2[j++];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7, 8, 10};
        int[] arr2 = {2, 4, 5, 6};
        System.out.println(Arrays.toString(mergeSortedArray(arr1, arr2)));
    }
}
