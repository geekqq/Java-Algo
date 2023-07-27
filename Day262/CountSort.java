package Day262;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class CountSort {

    public static int[] countSort(int[] nums) {
        //cc
        int[] newArr = Arrays.copyOf(nums, nums.length);
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
        int[] nums = randomArray(10, 20);
        printArray(nums);
        int[] sortedArr = countSort(nums);
        printArray(sortedArr);
    }
}
