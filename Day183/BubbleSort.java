package Day183;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;
import static Day44.SelectSort.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j + 1, j);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
}
