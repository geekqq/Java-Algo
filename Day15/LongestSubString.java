package Day15;

import Day12.LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "23were34221rew!";
        System.out.println(LengthOfLongestSubstring(s));
    }

    public static int LengthOfLongestSubstring(String s) {
        //双指针，快慢指针
        int left = 0, right = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
