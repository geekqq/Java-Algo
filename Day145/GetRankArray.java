package Day145;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetRankArray {
    public static void main(String[] args) {
        int[] nums = {20,40,10,10,20,30,50};
        System.out.println(Arrays.toString(getRankArray(nums)));
    }

    private static int[] getRankArray(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank++);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
