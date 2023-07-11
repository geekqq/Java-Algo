package Day258;

public class MissingNumber {

    public static int findMissingNum(int[] nums, int n) {
        int total = (n + 1) * n / 2;
        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
        }
        return total - arraySum;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 6, 7, 8};
        System.out.println(findMissingNum(nums, 8));
    }
}
