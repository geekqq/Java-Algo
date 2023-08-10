package Day267;

import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day37.SortedArray.swap;

public class ShuffleArray {

    public static int[] shuffleArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        for (int i = nums.length - 1; i >= 1; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(nums, i, j);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,2,7,1};
        nums = shuffleArray(nums);
        printArray(nums);
    }
}
