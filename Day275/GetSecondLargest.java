package Day275;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class GetSecondLargest {

    public static int getSecondMax(int[] arr) {
        if (arr == null || arr.length <= 1) throw new IllegalArgumentException("Invalid input!");
        int max = arr[0];
        int secondMax = max;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 18);
        printArray(arr);
        System.out.println(getSecondMax(arr));
    }
}
