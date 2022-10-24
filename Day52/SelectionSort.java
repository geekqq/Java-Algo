package Day52;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[10];
        System.out.println("The given array is: ");
        for (int i = 0; i < 10; i++) {
            nums[i] = rand.nextInt(101);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("The sorted array is: ");
        System.out.println(Arrays.toString(selectSort(nums)));
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] selectSort(int[] nums) {
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
        return nums;
    }
}
