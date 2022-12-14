package Day103;

public class FindMin {
    public static void main(String[] args) {
        int[] nums = {20};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
