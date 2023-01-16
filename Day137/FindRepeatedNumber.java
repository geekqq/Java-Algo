package Day137;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindRepeatedNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,7,6,5,4};
        System.out.println(findRepeatedNum(nums));
        System.out.println(findRepeatedNum2(nums));
    }

    private static int findRepeatedNum(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    private static int findRepeatedNum2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
