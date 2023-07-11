package Day257;

import java.util.Arrays;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;

public class CountSort {

    public static int[] countSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int max = Arrays.stream(nums).max().getAsInt();
        int len = max + 1;
        int[] bucket = new int[len];
        for (int value : arr) {
            bucket[value]++;
        }
        int indexSort = 0;
        for (int i = 0; i < len; i++) {
            while (bucket[i] > 0) {
                arr[indexSort++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 2, 19);
        printArray(nums);
        printArray(countSort(nums));
    }
}
