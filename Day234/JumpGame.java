package Day234;

public class JumpGame {

    public static boolean canJum(int[] nums) {
        if (nums == null || nums.length == 0) return true;

        int reachable = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + 1);
        }
        return true;
    }
}
