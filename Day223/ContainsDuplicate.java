package Day223;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
