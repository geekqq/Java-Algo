package Day37;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringTwo {
    public static void main(String[] args) {
        System.out.println(getLongestLengthOfSubstring("jinwei"));
    }

    public static int getLongestLengthOfSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

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
