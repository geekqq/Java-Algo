package Day49;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {1,0,3,4,3,23};
        System.out.println(Arrays.toString(reverseArray(nums)));
    }

    public static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newArr[n - 1 - i] = nums[i];
        }
        return newArr;
    }
}
