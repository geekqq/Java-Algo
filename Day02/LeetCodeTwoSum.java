package Day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTwoSum {
    //using brutal force
    public static void main(String[] args) {
        int[] array = {2,4,4,99,9,8};
        int target = 8;
        String res = Arrays.toString(twoSumUsingMap(array, target));
        System.out.println(res);


    }

    //using brutal force
    public static int[] twoSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    //using HashMap
    public static int[] twoSumUsingMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
            System.out.println(map);
        }
        return null;
    }

}
