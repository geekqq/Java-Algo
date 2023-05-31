package Day233;

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

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }
}
