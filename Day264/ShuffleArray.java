package Day264;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day37.SortedArray.swap;

public class ShuffleArray {

    public static void shuffleArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        for (int i = n - 1; i > 0 ; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            swap(nums, i, j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,52,23,1,34};
        printArray(nums);
        shuffleArray(nums);
        printArray(nums);
        Collections.shuffle(Arrays.asList(nums));
        printArray(nums);
    }
}
