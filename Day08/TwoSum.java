package Day08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3,7,8,};
        int target = 15;
        int[] res = getTwoSumUsingForLoop(nums, target);
        System.out.println(Arrays.toString(res));
        System.out.println("----------------");
        int[] res2 = getTwoSumUsingHashMap(nums, target);
        System.out.println(Arrays.toString(res2));
    }

    public static int[] getTwoSumUsingForLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] getTwoSumUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) return new int[] {map.get(diff), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
