package Day91;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j + 1, j);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3,2,5,6,3,7,8,7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
