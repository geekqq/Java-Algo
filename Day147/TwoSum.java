package Day147;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));

    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
