package Day37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10,30,20,50,40};
        System.out.println(Arrays.toString(reverseArray(arr)));
        reverseArraySwap(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(reverseIntArray(arr)));

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int t = arr[i];
            arr[i] = arr[n - 1 -i];
            arr[n - 1 - i] = t;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverseArray(int[] array) {
        int[] newArr = new int[array.length];
        int j = array.length;
        for (int i = 0; i < array.length; i++) {
            newArr[j - 1] = array[i];
            j = j - 1;
        }
        return newArr;
    }

    public static int[] reverseIntArray(int[] array) {
        int[] newArr = new int[array.length];
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            newArr[j] = array[i];
            j--;
        }
        return newArr;
    }

    public static void reverseArraySwap(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int t = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = t;
        }
    }
}
