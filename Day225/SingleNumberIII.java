package Day225;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int diff = 0;
        //after this loop, the diff == a XOR b
        for (int n : nums) {
            diff ^= n;
        }
        //find one bit that can distinguish a and b
        diff = Integer.highestOneBit(diff);
        int[] res = new int[2];
        for (int n : nums) {
            if ((diff & n) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
