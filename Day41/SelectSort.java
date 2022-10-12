package Day41;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr2 = {-2,4,8,6,7};
        System.out.println(Arrays.toString(selectSort(arr2)));
    }

    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
