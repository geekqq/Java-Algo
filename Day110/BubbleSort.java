package Day110;

import static Day37.MergeSortTwo.printArray;
import static Day37.SortedArray.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,4,0,2,7,3,2,5,0,9};
        bubbleSort(nums);
        printArray(nums);
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j +1]) {
                    swap(nums, j +1, j);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
