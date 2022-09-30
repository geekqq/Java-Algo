package Day25;

public class GetMaxElement {
    public static void main(String[] args) {
        int[] nums = {1221,2332,0,-112};
        System.out.println(getMaxElement(nums));
        System.out.println(getMinElement(nums));
    }

    public static int getMaxElement(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int getMinElement(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}
