package Day202;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetArrayRank {

    public static int[] arrayRank(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        int rank = 1;
        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank++);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {20,40,30,30,50,10,10};
        System.out.println(Arrays.toString(arrayRank(nums)));
    }
}
