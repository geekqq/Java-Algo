package Day214;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0 || target < 0) return res;

        dfs(res, candidates, 0, target, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] candidates, int index, int target, int sum, List<Integer> path) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target || index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(res, candidates, i, target, sum + candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSumI(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0 || target <= 0) return res;
        List<Integer> list = new LinkedList<>();
        getRes(nums, res, list, target, 0, 0);
        return res;
    }

    private static void getRes(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int sum, int index) {
        if (sum > target || index >= nums.length) return;
        if (sum == target) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            getRes(nums, res, list, target, sum + nums[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int[] candidates2 = {2,3,5};
        int target2 = 8;
        int target = 7;
        System.out.println(combinationSum(candidates, target));
        System.out.println(combinationSum(candidates2, target2));
        System.out.println(combinationSumI(candidates, target));
        System.out.println(combinationSumI(candidates2, target2));
    }
}
