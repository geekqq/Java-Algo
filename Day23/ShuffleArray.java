package Day23;

import java.util.Random;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = f();
        for (int i : nums) {
            System.out.println(i);
        }
        System.out.println("----");
        shuffle(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] f() {
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    public static void shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = new Random().nextInt(nums.length);
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
    }
}
