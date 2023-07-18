package Day261;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class FindSecondMax {

    public static int findSecondMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 18);
        printArray(nums);
        System.out.println(findSecondMax(nums));
    }
}
