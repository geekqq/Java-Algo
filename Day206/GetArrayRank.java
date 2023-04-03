package Day206;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static Day138.RandomArray.randomArray;

public class GetArrayRank {

    public static int[] getArrayRank(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        Map<Integer, Integer> map = new HashMap<>();
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
        int[] nums = {10,30,20,20,40,50,30,60};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(getArrayRank(nums)));
    }
}
