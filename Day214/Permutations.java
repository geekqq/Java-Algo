package Day214;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        getRes(nums, res, new ArrayList<>(), new HashSet<Integer>(),0);
        return res;
    }

    private static void getRes(int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> set, int index) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            getRes(nums, res, list, set, i);
            list.remove(list.size() - 1);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permutation(nums));
    }
}
