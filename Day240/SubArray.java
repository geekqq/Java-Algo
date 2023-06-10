package Day240;

import java.util.*;

public class SubArray {


    public static List<List<Integer>> getAllSubArrays(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(nums[k]);
                }
                res.add(subArray);
            }
        }
        return res;
    }

    //use this method to check if the subArray is valid:
    public static boolean isMaxProfitable(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return false;
        // if the subArray only has ONE or TWO element it is valid
        if (nums.size() == 1 || nums.size() == 2) return true;
        int max = Collections.max(nums); // Get the max value of the subArray
        if (nums.get(0) == max || nums.get(nums.size() - 1) == max) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 5};
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1, 5, 2};
        System.out.println(getAllSubArrays(nums));
        System.out.println(getAllSubArrays(nums1));
        List<List<Integer>> allSubArrays = getAllSubArrays(nums2);
        int count = 0;
        for (List<Integer> subArray : allSubArrays) {
            if (isMaxProfitable(subArray)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
