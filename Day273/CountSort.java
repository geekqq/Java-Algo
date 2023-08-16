package Day273;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class CountSort {

    public static int[] countSort(int[] arr) {
        //cc
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int len = Arrays.stream(newArr).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int value : newArr) {
            bucket[value]++;
        }
        int indexSorted = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                newArr[indexSorted++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        int[] newArr = countSort(arr);
        printArray(newArr);
    }
}
