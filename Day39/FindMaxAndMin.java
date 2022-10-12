package Day39;

public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] nums = {5,23,6,4,-2,7,0};
        System.out.println(getMax(nums));
        System.out.println(getMin(nums));
    }
    public static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
