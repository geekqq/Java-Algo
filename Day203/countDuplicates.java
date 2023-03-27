package Day203;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class countDuplicates {

    public static void countDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("the duplicate number is:" + nums[i]);
            }
            count = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = randomArray(5, 20);
        System.out.println(Arrays.toString(nums));
        countDuplicates(nums);
    }
}
