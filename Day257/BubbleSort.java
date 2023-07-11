package Day257;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 2, 18);
        printArray(nums);
        bubbleSort(nums);
        printArray(nums);
    }
}
