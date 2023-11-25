package Day327;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ProductArray {

    public static int[] productArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        int tmp = 1;
        for (int i = 0; i < arr.length; i++) {
            res[i] = tmp;
            tmp *= arr[i];
        }
        tmp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(4, 10);
        printArray(arr);
        int[] res = productArray(arr);
        printArray(res);
    }
}
