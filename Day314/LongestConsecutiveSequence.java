package Day314;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestSequence(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 0;
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 3, 7, 2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,10};
        System.out.println(longestSequence(nums));
        System.out.println(longestSequence(nums1));
    }
}
