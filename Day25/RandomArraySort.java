package Day25;

import java.util.Arrays;
import java.util.Random;

public class RandomArraySort {
    public static void main(String[] args) {
        int[] nums = new int[22];
        for (int i = 0; i < 22; i++) {
            nums[i] = new Random().nextInt(101);
        }

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
