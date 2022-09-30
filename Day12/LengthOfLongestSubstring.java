package Day12;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "hello1@2";
        System.out.println(getLengthOfLongestSubstring(s));
    }

    public static int getLengthOfLongestSubstring(String s) {
        //Using set
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
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
