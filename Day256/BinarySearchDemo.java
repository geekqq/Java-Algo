package Day256;

public class BinarySearchDemo {

    public static int bs(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (nums[r] == t) return r;
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,7,8};
        System.out.println(bs(nums, 10));
    }
}
