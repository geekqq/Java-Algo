package Day136;

public class FindRepeatedNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,7,6,5,4};
        System.out.println();
        System.out.println(findRepeatedNumber(nums));
    }
    private static int findRepeatedNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }

        int n = nums.length - 1;
        int sum = (n + 1) * n / 2;
        return arraySum - sum;
    }
}
