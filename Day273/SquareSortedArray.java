package Day273;

import java.util.Arrays;

public class SquareSortedArray {

    public static int[] squareSortedArray(int[] arr) {
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
        int[] arr = {-5, -2, 3, 4, 8, 10};
        System.out.println(Arrays.toString(squareSortedArray(arr)));
    }
}
