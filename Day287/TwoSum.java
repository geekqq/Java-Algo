package Day287;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumI(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static int[] twoSumII(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (!map.containsKey(diff)) {
                map.put(arr[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(diff);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 5, 10, 8, 7};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumI(nums, target)));
        System.out.println(Arrays.toString(twoSumII(nums, target)));
    }
}
