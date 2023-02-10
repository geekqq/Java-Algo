package Day162;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetRankArray {
    public static void main(String[] args) {
        int[] nums = {30,20,40,40,20,10,50};
        System.out.println(Arrays.toString(getRankArray(nums)));
    }

    private static int[] getRankArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        Arrays.sort(newArr);
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
