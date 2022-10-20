package Day49;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int[] nums2 = {2,4,6,8,};
        System.out.println(Arrays.toString(mergeSortedArray(nums2,nums)));
    }

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] newArr = new int[n + m];
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < n && r < m) {
            if (arr1[l] <= arr2[r]) {
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
