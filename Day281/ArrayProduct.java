package Day281;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ArrayProduct {

    public static int[] arrayProduct(int[] arr) {
        int temp = 1;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp = temp * arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(5, 10);
        printArray(arr);
        int[] newArr = arrayProduct(arr);
        printArray(newArr);
    }
}
