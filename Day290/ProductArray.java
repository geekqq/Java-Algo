package Day290;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ProductArray {

    public static int[] arrayProduct(int[] arr) {
        int[] res = new int[arr.length];
        if (arr == null || arr.length == 0) return res;
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
        int[] arr = randomArray(5, 7);
        printArray(arr);
        int[] res = arrayProduct(arr);
        printArray(res);
    }
}
