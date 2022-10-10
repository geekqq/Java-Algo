package Day39;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2,4,6,8};
        int[] arr2 = {1,3,5,7};
        System.out.println(Arrays.toString(mergeTwoArraySorted(arr1, arr2)));
    }

    public static int[] mergeTwoArraySorted(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] newArr = new int[n + m];
        int l = 0;
        int r = 0;
        int k = 0;
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
