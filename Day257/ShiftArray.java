package Day257;

import java.util.Arrays;

public class ShiftArray {
    public static int[] shiftArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(shiftArray(nums)));
    }
}
