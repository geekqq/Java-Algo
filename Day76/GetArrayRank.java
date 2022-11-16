package Day76;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {
    public static void main(String[] args) {
        int[] nums = {30,20,50,40,10};
        System.out.println(Arrays.toString(getRank(nums)));
    }

    public static int[] getRank(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
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
