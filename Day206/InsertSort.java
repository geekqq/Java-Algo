package Day206;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class InsertSort {

    public static void insertSort(int[] nums) {
        if (nums == null) return;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(20, 10);
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
