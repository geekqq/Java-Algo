package Day00;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTwoSum {

    public static void main(String[] args) {
        int[] nums = {3,1,8};
        int target = 5;
        int[] ans = twoSumUsingHashMap(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int diff = target - nums[i];
            if (map.containsKey(diff) && (map.get(diff) != i)) {
                return new int[] {map.get(diff), i};
            }
        }
        //throw new IllegalArgumentException("No match found!");
        return null;
    }
}
