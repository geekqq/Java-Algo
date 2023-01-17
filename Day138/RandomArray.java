package Day138;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static int[] randomArray(int n, int m) {
        //generate a random array size of m with the element from 0 to n - 1;
        Random rand = new Random();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = rand.nextInt(n);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(101, 10);
        System.out.println(Arrays.toString(nums));
    }
}
