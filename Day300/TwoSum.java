package Day300;

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
        return new int[] {-1, -1};
    }

    public static int[] twoSumI(int[] arr, int target) {
        if (arr  == null || arr.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (!map.containsKey(diff)) {
                map.put(arr[i], i);
            } else {
                return new int[] {i, map.get(diff)};
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSumII(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[] {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                res[0] = i;
                res[1] = map.get(diff);
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 8};
        int target = 14;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSumI(arr, target)));
        System.out.println(Arrays.toString(twoSumII(arr, target)));
    }
}
