package Day103;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {20,20,40,30,10,30,50,40};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = i + 1; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
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
