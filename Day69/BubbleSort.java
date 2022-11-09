package Day69;

import java.util.Arrays;

import static Day44.SelectSort.swap;
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {23, 12, -3, 1, 8, -3, 0, 90, 90};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums,j, j + 1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
}
