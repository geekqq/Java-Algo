package Day58;

import java.util.HashSet;
import java.util.Set;

public class GetLengthOfSubString {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihu"));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxLen = Math.max(maxLen, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
