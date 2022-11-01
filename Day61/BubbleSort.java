package Day61;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, 1, 8, -3, 0, 90};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }
}
