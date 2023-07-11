package Day257;

import static Day256.RandomArray.randomArray;
import static Day37.MergeSortTwo.printArray;

public class FindMinArray {

    public static int findMin(int[] nums) {

        //edge case
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 100);
        printArray(nums);
        System.out.println(findMin(nums));
    }
}
