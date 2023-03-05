package Day184;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRanks {
    public static void main(String[] args) {
        int[] nums = {20,10,40,40,20,50,30};
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }
    public static int[] getArrayRank(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i],  rank++);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
