package Day303;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.countSort;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class ColorSort {

    public static void colorSort(int[] color) {
        if (color == null || color.length == 0) return;
        int i = 0;
        int j = 0;
        int k = color.length - 1;
        while (i <= k) {
            if (color[i] == 0) {
                swap(color, i++, j++);
            } else if (color[i] == 1) i++;
            else if (color[i] == 2) {
                swap(color, i, k--);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 2);
        printArray(arr);
        colorSort(arr);
        printArray(arr);
    }
}
