package Day233;

import java.util.Arrays;

public class MaxSubArray {

    //LC53

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] res = new int[nums.length];

        res[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + (res[i - 1] < 0 ? 0 : res[i - 1]);
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public static int maxSumSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSumSubArray(nums));

    }
}
