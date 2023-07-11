package Day257;

import static Day254.SelectSort.generateRandomArrayWithoutDuplicates;
import static Day256.PrintArray.printArray;

public class InsertSort {

    public static void insertSort(int[] nums) {
        //cc
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithoutDuplicates(10, 2, 18);
        printArray(nums);
        insertSort(nums);
        printArray(nums);
    }
}
