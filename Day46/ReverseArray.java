package Day46;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,23,4,};
        System.out.println(Arrays.toString(reverseArray(nums)));
    }
    public static int[] reverseArray(int[] nums) {
        int n = nums.length - 1;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[n--] = nums[i];
        }
        return newArr;
    }
}
