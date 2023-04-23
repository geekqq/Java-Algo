package Day216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> list = new ArrayList<>();
        getRes(nums, res, list, target, 0, 0);
        return res;
    }

    private static void getRes(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int sum, int index) {
        if (sum > target || index >= nums.length) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            getRes(nums, res, list, target, sum + nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
