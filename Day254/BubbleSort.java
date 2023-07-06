package Day254;

import Day253.ArrayDemo;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSortII(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j + 1, j);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,6,2,2,5,27,23};
        bubbleSortII(nums);
        System.out.println(Arrays.toString(nums));
    }
}
