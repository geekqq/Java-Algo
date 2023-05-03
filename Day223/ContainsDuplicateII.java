package Day223;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearByDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearByDuplicate(nums, k));
    }
}
