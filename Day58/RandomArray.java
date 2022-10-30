package Day58;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[50];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(101);
        }
        System.out.println(Arrays.toString(nums));
    }
}
