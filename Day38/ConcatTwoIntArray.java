package Day38;

import java.util.Arrays;

public class ConcatTwoIntArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,5};
        System.out.println(Arrays.toString(concatArrays(arr1, arr2)));
    }

    public static int[] concatArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] newArr = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            newArr[k++] = arr1[i];
        }
        for (int i = 0; i < m; i++) {
            newArr[k++] = arr2[i];
        }
        return newArr;
    }
}
