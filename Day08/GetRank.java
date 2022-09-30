package Day08;

import java.util.*;

public class GetRank {
    public static void main(String[] args) {
        int[] nums = {40, 10,30,20,40};
        int[] res = getRankArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getRankArray(int[] nums) {
        //Using set
        //creat a copy of the given array
        int[] newArr = Arrays.copyOfRange(nums, 0, nums.length);
        //sort the new array
        Arrays.sort(newArr);
        int rank = 1;
        int[] res = new int[newArr.length];
        //Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newArr.length; i++) {
            if (!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
