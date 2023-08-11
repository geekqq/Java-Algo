package Day268;

import java.util.Arrays;

import static Day256.PrintArray.printArray;

public class MergeSort {

    public static void sort(int[] nums, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(nums, temp, low, mid);
            sort(nums, temp, mid + 1, high);
            merge(nums, temp, low, mid, high);
        }
    }

    private static void merge(int[] nums, int[] temp, int low, int mid, int high) {

        for (int i = low; i <= high ; i++) {
            temp[i] = nums[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1, 0, -1,5,2,3,4,7};
        sort(nums, new int[nums.length], 0, nums.length - 1);
        printArray(nums);
    }
}
