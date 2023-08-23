package Day278;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
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

    public static int[] twoSumForLoop(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }

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

    public static int[] twoSumSort(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        Arrays.sort(arr);
        int[] res = new int[2];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                res[0] = arr[left];
                res[1] = arr[right];
                return res;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] nums = {2, 11, 5, 10, 8, 7};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumI(nums, target)));
        System.out.println(Arrays.toString(twoSumForLoop(nums, target)));
        System.out.println(Arrays.toString(twoSumSort(nums, target))); // this one will generate the elements not the index
    }
}
