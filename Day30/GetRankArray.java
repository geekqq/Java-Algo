package Day30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetRankArray {
    public static void main(String[] args) {
        int[] nums = {30, 50, 10, 30, 20, 40};
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }

    public static int[] getArrayRank(int[] nums) {
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(newArr);
        int rank = 1;
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
