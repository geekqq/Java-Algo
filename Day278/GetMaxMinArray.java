package Day278;

import java.util.Arrays;

public class GetMaxMinArray {

    public static void getMaxMinArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int maxIdx = arr.length - 1;
        int max = arr[maxIdx] + 1;
        int minIdx = 0;
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
            arr[i] /= max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4 ,7,9, 11};
        getMaxMinArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
