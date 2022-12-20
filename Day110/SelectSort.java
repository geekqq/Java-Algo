package Day110;

import static Day37.MergeSortTwo.printArray;
import static Day37.SortedArray.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1,4,0,2,7,3,2,5,0,9};
        selectSort(nums);
        printArray(nums);
    }
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
