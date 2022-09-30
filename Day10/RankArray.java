package Day10;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankArray {
    public static void main(String[] args) {
        int[] nums = {40,10,30,20,100};
        getRankArray(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("-----Sorting array with decending order-----");
        Integer[] nums2 = {1,2,3,4,5,6,7};
        Arrays.sort(nums2, Collections.reverseOrder());
        System.out.println(Arrays.toString(nums2));
        System.out.println("---------------");
        String s = "Hello!";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int[] getRankArray(int[] nums) {
        //create the copy of the given array
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
