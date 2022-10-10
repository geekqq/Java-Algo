package Day38;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {
    public static void main(String[] args) {
        int[] nums = {20,50,20,10,40,30};
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }

    public static int[] getArrayRank(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 1) return new int[]{1};
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
