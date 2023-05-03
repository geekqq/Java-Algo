package Day223;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
