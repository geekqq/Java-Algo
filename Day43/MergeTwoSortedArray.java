package Day43;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {-1,3,5,7,7};
        int[] arr2 = {-2,4,4,6,7};
        System.out.println(Arrays.toString(mergeTwo(arr1, arr2)));
    }

    public static int[] mergeTwo(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;

        int n = arr1.length;
        int m = arr2.length;
        int[] newArr = new int[n + m];
        int k = 0;
        int l = 0;
        int r = 0;
        while (l < n && r < m) {
            newArr[k++] = arr1[l] <= arr2[r] ? arr1[l++] : arr2[r++];
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
