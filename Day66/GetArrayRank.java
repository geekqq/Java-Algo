package Day66;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {
    public static void main(String[] args) {
        int[] nums = {10,40,20,20,30,50};
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }

    public static int[] getArrayRank(int[] nums) {
        int rank = 1;
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
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
