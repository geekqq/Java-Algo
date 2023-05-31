package Day233;

public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int max = nums[0];
        int curMax, curMin;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            curMax = Math.max(Math.max(preMax * temp, preMin * temp), temp);
            curMin = Math.min(Math.min(preMax * temp, preMin * temp), temp);
            max = Math.max(curMax, max);
            preMax = curMax;
            preMin = curMin;
        }

        return max;
    }
}
