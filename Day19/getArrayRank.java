package Day19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class getArrayRank {
    public static void main(String[] args) {
        int[] nums = {20, 10, 40, 40, 60, 50};
        int[] res = getArrayRank(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getArrayRank(int[] nums) {
        //copy of the original array
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
