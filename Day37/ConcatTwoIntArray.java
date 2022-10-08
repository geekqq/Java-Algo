package Day37;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConcatTwoIntArray {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {2,2,4,5,6,};

        System.out.println(Arrays.toString(concatArray(array1, array2)));
        System.out.println(Arrays.toString(concatArray2(array1, array2)));
    }

    public static int[] concatArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = arr1.length + arr2.length;
        int[] newArr = new int[len];
        int newIndex = 0;
        for (int i = 0; i < n; i++) {
            newArr[newIndex++] = arr1[i];
        }
        for (int i = 0; i < m; i++) {
            newArr[newIndex++] = arr2[i];
        }
        return newArr;
    }

    public static int[] concatArray2(int[] arr1, int[] arr2) {
        int[] newArr = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
        return newArr;
    }
}
