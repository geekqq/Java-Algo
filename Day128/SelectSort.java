package Day128;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,4,5,5,1,0,7,4,6};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] nums) {
        //cc cases
        int mindIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            mindIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[mindIndex] > nums[j]) {
                    mindIndex = j;
                }
            }
            swap(nums, i, mindIndex);
        }
    }
}
