package Day274;

import java.util.Arrays;

public class SquareSortedArray {

    public static int[] squareSortedArray(int[] arr) {
        //cc

        int[] newArr = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        for (int k = arr.length - 1; k >= 0; k--) {
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
        int[] arr = {-12, -4, 1, 5, 7, 10};
        System.out.println(Arrays.toString(squareSortedArray(arr)));
    }
}
