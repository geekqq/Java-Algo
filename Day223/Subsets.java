package Day223;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        res.add(new ArrayList<>());
        getRes(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private static void getRes(List<List<Integer>> res, int[] nums, int level, List<Integer> list) {
        if (level == nums.length) return;
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            getRes(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
