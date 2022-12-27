package Day116;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,8,3,4,5,6,9,10};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j + 1, j);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
