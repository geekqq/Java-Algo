package Day23;

public class MaxElementInArr {
    public static void main(String[] args) {
        int[] nums = {9, 1562, 43, 22, 44, -9, 0, -1234, 6666};
        System.out.println(getMaxElement(nums));
    }

    public static int getMaxElement(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
