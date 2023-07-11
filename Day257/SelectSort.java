package Day257;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class SelectSort {
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 2, 19);
        printArray(nums);
        selectSort(nums);
        printArray(nums);
    }
}
