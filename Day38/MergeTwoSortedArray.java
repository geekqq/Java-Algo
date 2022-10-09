package Day38;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,9};
        int[] arr2 = {5,6,7,8,10};
        System.out.println(Arrays.toString(mergeTwoSortedArray(arr1, arr2)));
    }

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] newArr = new int[n + m];
        int k = 0;
        int l = 0;
        int r = 0;
        while (l < n && r < m) {
            if (arr1[l] < arr2[r]) {
                newArr[k++] = arr1[l++];
            } else {
                newArr[k++] = arr2[r++];
            }
        }
        while (l < n) {
            newArr[k++] = arr1[l++];
        }
        while (r < m) {
            newArr[k++] = arr2[r++];
        }
        return newArr;
    }
}
