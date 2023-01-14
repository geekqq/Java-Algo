package Day134;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1,0,1,4,3,5,2,0};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
