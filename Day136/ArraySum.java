package Day136;

public class ArraySum {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,-4,0,2};
        System.out.println(arraySum(nums));
    }
    private static int arraySum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
