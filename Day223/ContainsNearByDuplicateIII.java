package Day223;

import java.util.TreeSet;

public class ContainsNearByDuplicateIII {

    public static boolean containsNearByDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) {
                bst.remove(nums[i - k - 1]);
            }
            int higherBound = nums[i] + t;
            int lowerBond = nums[i] - t;
            Integer val = bst.floor(higherBound);
            if (val != null && val >= lowerBond) {
                return true;
            }
            bst.add(nums[i]);
        }
        return false;
    }

    public static boolean containsNearByDuplicates(int[] nums, int indexDiff, int valDiff) {
        if (nums == null || nums.length == 0) return false;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                set.remove(Long.valueOf(nums[i - indexDiff - 1]));
            }

            Long upper = (long)nums[i] + valDiff;
            Long lower = (long)nums[i] - valDiff;

            Long temp = set.lower(upper + 1);
            if (temp != null && temp >= lower) {
                return true;
            }
            set.add(Long.valueOf(nums[i]));
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums1 = {1,5,9,1,5,9};
        System.out.println(containsNearByDuplicate(nums, 3, 0));
        System.out.println(containsNearByDuplicates(nums, 3, 0));
        System.out.println(containsNearByDuplicate(nums1, 2, 3));
        System.out.println(containsNearByDuplicates(nums1, 2, 3));
    }
}
