package Day46;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,23,4,};
        System.out.println(Arrays.toString(reverseArray(nums)));
    }
    public static int[] reverseArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int[] newArr = new int[nums.length];
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            newArr[n--] = nums[i];
        }
        return newArr;
    }
}
