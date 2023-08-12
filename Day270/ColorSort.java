package Day270;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class ColorSort {
    public static void colorSort(int[] color) {
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
        int[] color = randomArray(10, 2);
        printArray(color);
        colorSort(color);
        printArray(color);
    }
}
