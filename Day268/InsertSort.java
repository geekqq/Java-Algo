package Day268;

import static Day256.PrintArray.printArray;
import static Day265.generateRandomArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class InsertSort {

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = generateArrayWithoutDuplicates(10, 3, 18);
        printArray(nums);
        insertSort(nums);
        printArray(nums);
    }
}
