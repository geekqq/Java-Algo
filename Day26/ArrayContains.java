package Day26;

public class ArrayContains {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 30;
        System.out.println(ifContains(nums, n));
    }

    public static boolean ifContains(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == n) {
                return true;
            }
        }
        return false;
    }
}
