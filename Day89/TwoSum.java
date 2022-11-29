package Day89;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int t = 6;
        System.out.println(Arrays.toString(twoSum(nums, t)));
        System.out.println(Arrays.toString(twoSum2(nums, t)));

    }
    public static int[] twoSum(int[] nums, int t) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == t) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public static int[] twoSum2(int[] nums, int t) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = t - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
