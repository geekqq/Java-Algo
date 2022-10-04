package Day33;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0,3,2,8};
        int target = 11;

        System.out.println(Arrays.toString(getTwoSum(nums, target)));
        System.out.println(Arrays.toString(getTwoSumTwo(nums, target)));


    }

    public static int[] getTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] getTwoSumTwo(int[] nums, int target) {
        //using map
        Map<Integer,Integer> map = new HashMap<>();
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
