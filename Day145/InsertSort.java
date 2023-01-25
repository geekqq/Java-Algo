package Day145;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = randomArray(15,12);
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}
