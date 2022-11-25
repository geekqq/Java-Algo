package Day85;

import java.util.Arrays;

import static Day44.SelectSort.swap;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {30,10,20,40,50,10};
        int[] nums1 = {1};
        selectSort(nums);
        selectSort(nums1);
        System.out.println(Arrays.toString(nums1));
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
