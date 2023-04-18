package Day214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSumII(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        getRes(nums, res, list, target, 0);
        return res;
    }
    private static void getRes(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            getRes(nums, res, list, target - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        int[] nums1 = {2,5,2,1,2};
        int target1 = 5;
        System.out.println(combinationSumII(nums, target));
        System.out.println(combinationSumII(nums1, target1));
    }
}
