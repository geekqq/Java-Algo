package Day289;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 0;
                while (set.contains(cur)) {
                    cur++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);
        for (int num : nums1) {
            set1.add(num);
        }

        System.out.println("====set1====");
        System.out.println(set1);
        System.out.println(longestConsecutiveSequence(nums));
        System.out.println(longestConsecutiveSequence(nums1));
    }
}
