package Day60;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {64, 34,25,12,22,11,90};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("----------------------");
        int[] arr = {23, 12, 1, 8, -3, 0, 90};
        bubbleSort2(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    //swap nums[j] and nums[j + 1]
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
        }
    }
    //recursion version of bubble sort
    public static void bubbleSort2(int[] nums, int n) {
        if (n == 0 || n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
        bubbleSort2(nums, n - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
