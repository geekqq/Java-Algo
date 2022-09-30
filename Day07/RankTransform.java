package Day07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransform {
    public static void main(String[] args) {
        int[] nums = {40, 10,20,30, 40};
        int[] res = getRankArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getRankArray(int[] nums) {
        //get copy of the given arr;
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(newArr);
        int[] res = new int[nums.length];
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
