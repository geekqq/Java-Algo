package Day284;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ProductArray {

    public static int[] productArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            res[i] = temp;
            temp *= arr[i];
        }

        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(6, 10);
        printArray(arr);
        System.out.println(Arrays.toString(productArray(arr)));
    }
}
