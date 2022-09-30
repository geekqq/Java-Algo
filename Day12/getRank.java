package Day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class getRank {
    public static void main(String[] args) {
        int[] nums = {40};
        //int[] res = getRankArray(nums);
        System.out.println(Arrays.toString(getRankArray(nums)));
    }

    public static int[] getRankArray(int[] nums) {
        //corner cases
        if (nums == null || nums.length == 0) return null;

        //using map to sort the copy of the original array
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        int rank = 1;
        Arrays.sort(newArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newArr.length; i++) {
            if(!map.containsKey(newArr[i])) {
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
