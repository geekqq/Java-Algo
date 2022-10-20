package Day48;

public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] nums = {30,20,20,10,40,50};
        System.out.println(getMax(nums));
        System.out.println(getMin(nums));
    }

    public static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int getMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
