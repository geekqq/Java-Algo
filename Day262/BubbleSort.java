package Day262;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;;
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 20);
        printArray(nums);
        bubbleSort(nums);
        printArray(nums);
    }
}
