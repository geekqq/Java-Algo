package Day23;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "wqersdafds!";
        System.out.println(getLengthOfLongestSubstring(s));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxlength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxlength = Math.max(maxlength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
}
