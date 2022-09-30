package Day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRank {
    public static void main(String[] args) {
        int[] nums = {20, 40, 10, 30, 20,};
        System.out.println(Arrays.toString(getRankArray(nums)));
    }
    public static int[] getRankArray(int[] nums) {
        //Create a copy of the original array
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        int rank = 1;
        Arrays.sort(newArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
