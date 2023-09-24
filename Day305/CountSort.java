package Day305;

import Day11.ArrayRank;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class CountSort {

    public static int[] countSort(int[] arr) {
        //cc
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int len = Arrays.stream(newArr).max().getAsInt() + 1;
        int[] bucket = new int[len];
        for (int i : newArr) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                newArr[index++] = i;
                bucket[i]--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 20);
        printArray(arr);
        int[] res = countSort(arr);
        printArray(res);
    }
}
