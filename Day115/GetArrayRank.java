package Day115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {
    public static int[] getArrayRank(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < newNums.length; i++) {
            if (!map.containsKey(newNums[i])) {
                map.put(newNums[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {40,20,40,50,50,10,30};
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }
}
