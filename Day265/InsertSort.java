package Day265;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day265.generateRandomArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class InsertSort {

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
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
        int[] nums = generateArrayWithoutDuplicates(8, 3, 15);
        printArray(nums);
        int[] newArr = countSort(nums);
        printArray(newArr);
    }
}
