package Day47;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {1,0,3,4,3,23,5,};
        System.out.println(Arrays.toString(reverseArray(nums)));
        swapArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[n - 1 - i] = nums[i];
        }
        return newArr;
    }

    public static void swapArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }
}
