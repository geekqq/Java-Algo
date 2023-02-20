package Day171;

import java.util.Arrays;

import static Day138.RandomArray.randomArray;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        printDuplicatesInArray(nums);
    }

    private static void printDuplicatesInArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("the duplicated element is: " + nums[i]);
            }
            count = 0;
        }
    }
}
