package Day255;

import java.util.Arrays;

import static Day255.RandomArray.randomArray;

public class InsertSort {

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > key) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 100);
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
