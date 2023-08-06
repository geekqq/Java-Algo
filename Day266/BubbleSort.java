package Day266;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        boolean swap = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) break;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 9, 2, 5, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        printArray(nums);
    }
}
