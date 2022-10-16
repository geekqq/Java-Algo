package Day44;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,2,4,0,5};
        int t = 4;
        System.out.println(Arrays.toString(twoSum(nums, t)));
        System.out.println(Arrays.toString(twoSumUsingMap(nums, t)));
    }

    public static int[] twoSum(int[] nums, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == t) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumUsingMap(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = t - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
