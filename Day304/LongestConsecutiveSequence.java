package Day304;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int getLongestSequence(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 0;
                int cur = i;
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
        int[] nums = {100, 4, 3, 7, 2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,10};
        System.out.println(getLongestSequence(nums));
        System.out.println(getLongestSequence(nums1));
    }
}
