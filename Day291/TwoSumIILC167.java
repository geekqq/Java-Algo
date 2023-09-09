package Day291;

import java.util.Arrays;

public class TwoSumIILC167 {

    public static int[] twoSumII(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7 , 11, 15};
        System.out.println(Arrays.toString(twoSumII(nums, 9)));
    }
}
