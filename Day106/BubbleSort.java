package Day106;

import java.util.Arrays;

import static Day37.SortedArray.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,4,1,2,7,5,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
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
}
