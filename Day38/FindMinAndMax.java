package Day38;

public class FindMinAndMax {
    public static void main(String[] args) {
        int[] nums = {4,7,0,-1,9,5,7,12};
        System.out.println(getMax(nums));
        System.out.println(getMin(nums));
    }
    public static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (max < nums[i + 1]) {
                max = nums[i + 1];
            }
        }
        return max;
    }

    public static int getMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (min > nums[i + 1]) {
                min = nums[i + 1];
            }
        }
        return min;
    }
}

