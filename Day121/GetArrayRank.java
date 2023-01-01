package Day121;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {
    public static void main(String[] args) {
        int[] nums = {20,50,10,30,30,40};
        System.out.println(Arrays.toString(getArrayRank(nums)));

    }
    public static int[] getArrayRank(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] newArr = Arrays.copyOf(nums, nums.length);
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
