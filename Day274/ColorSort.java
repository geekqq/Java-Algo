package Day274;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class ColorSort {

    public static void sortColor(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i++, j++);
            } else if (arr[i] == 1) i++;
            else if (arr[i] == 2) {
                swap(arr, i, k--);
            }
        }
    }

    public static void main(String[] args) {
        int[] color = randomArray(10, 2);
        printArray(color);
        sortColor(color);
        printArray(color);
    }
}
