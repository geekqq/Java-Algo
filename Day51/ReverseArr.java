package Day51;

import java.util.Arrays;

public class ReverseArr {
    public static void main(String[] args) {
        int[] nums = {2,5,3,7,0,-2};
        System.out.println(Arrays.toString(reverseArr(nums)));
        System.out.println(Arrays.toString(swapArr(nums)));
    }

    public static int[] reverseArr(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = nums[n - 1 - i]; // or can be done by newArr[n - 1 - i] = nums[i];
        }
        return newArr;
    }

    public static int[] swapArr(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        return nums;
    }
}
