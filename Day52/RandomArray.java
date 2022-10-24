package Day52;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    //generate a random int array

    public static int[] generateRandomArray(int len, int range) {
        //len is the size of array
        //range is the random number range form 0 to range - 1;
        Random rand = new Random();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = rand.nextInt(range);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArray(10, 101);
        System.out.println(Arrays.toString(nums));
    }
}
