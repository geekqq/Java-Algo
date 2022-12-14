package Day103;

public class FindMax {
    public static void main(String[] args) {
        int[] nums = {20,20,40,30,10,30,50,40};
        System.out.println(findMax(nums));
    }
    public static int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
