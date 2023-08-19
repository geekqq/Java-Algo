package Day275;

import java.util.Arrays;

public class SquareSortedArray {

    public static int[] getSquareSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] newArr = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        for (int k = arr.length - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                newArr[k] = arr[j] * arr[j--];
            } else {
                newArr[k] = arr[i] * arr[i++];
            }
        }
        return newArr;
    }

    public static int[] getI(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] newArr = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        for (int k = newArr.length - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                newArr[k] = arr[j] * arr[j];
                j--;
            } else {
                newArr[k] = arr[i] * arr[i];
                i++;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {-12, -3, 0, 4, 8, 19};
        System.out.println(Arrays.toString(getSquareSortedArray(arr)));
        System.out.println(Arrays.toString(getI(arr)));
    }
}
