package Day136;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,3,2,4,5};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicateUsingSet(nums));
    }
    private static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
