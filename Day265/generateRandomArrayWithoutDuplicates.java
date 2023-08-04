package Day265;

import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class generateRandomArrayWithoutDuplicates {

    public static int[] generateArrayWithoutDuplicates(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Random rd = new Random();
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = generateArrayWithoutDuplicates(10, 3,19);
        printArray(nums);
        sort(nums, 0, nums.length - 1);
        printArray(nums);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < nums.length - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }
}
