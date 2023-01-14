package Day134;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,0,1,4,6,3,5,2,0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
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
