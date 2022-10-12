package Day41;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {-1,3,5,7,7};
        int[] arr2 = {-2,4,4,6,7};
        System.out.println(Arrays.toString(mergeTwoSortedArray(arr1, arr2)));
    }

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] newaArr = new int[n + m];
        int l = 0;  //index of arr1
        int r = 0;  //index of arr2
        int k = 0;  //index of new array

        while (l < n && r < m) {
            if (arr1[l] < arr2[r]) {
                newaArr[k++] = arr1[l++];
            } else {
                newaArr[k++] = arr2[r++];
            }
        }
        while (l < n) {
            newaArr[k++] = arr1[l++];
        }
        while (r < m) {
            newaArr[k++] = arr2[r++];
        }
        return newaArr;
    }
}
