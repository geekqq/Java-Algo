package Day262;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class InsertSort {

    public static void insertSort(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = randomArray(10, 20);
        printArray(nums);
        insertSort(nums);
        printArray(nums);
    }
}
