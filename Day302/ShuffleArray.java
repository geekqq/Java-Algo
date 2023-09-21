package Day302;

import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day65.BubbleSort.swap;

public class ShuffleArray {

    public static void shuffleArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = arr.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(arr, i, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        shuffleArray(arr);
        printArray(arr);
    }
}
