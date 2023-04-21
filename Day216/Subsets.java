package Day216;

import OODAdv.A;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        getRes(res, nums, 0, new ArrayList<>());
        return res;
    }
    private static void getRes(List<List<Integer>> res, int[] nums, int level, List<Integer> list) {
        if (level == nums.length) {
            return;
        }
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            getRes(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(res, nums, index + 1, path);
        path.remove(path.size() - 1);
        dfs(res, nums, index + 1, path);
    }
    public static void main(String[] args) {
        int[] nums = {1 ,2, 3};
        System.out.println(subsets(nums));
        System.out.println(subsetsI(nums));
    }
}
