package Day32;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            int j = new Random().nextInt(a.length);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static int[] shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = new Random().nextInt(nums.length);
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
