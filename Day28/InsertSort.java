package Day28;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, 23, 343, 2, 0, 7, 45};
        System.out.println(Arrays.toString(insertSort(nums)));
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                arr[j + 1] = temp;
            }
        }
        return arr;
    }
}
