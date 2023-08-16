package Day272;

import java.util.Arrays;

public class MaxMinArray {

    public static int[] getMaxMinArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int max = arr[maxIdx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,3, 4, 5,7, 9};
        System.out.println(Arrays.toString(getMaxMinArray(arr)));
    }
}
