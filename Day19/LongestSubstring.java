package Day19;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "23were";
        System.out.println(getLengthOfLongestSubstring(s));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        Set<Character> mySet = new HashSet<>();

        while (right < s.length()) {
                char c = s.charAt(right);
                if (mySet.add(c)) {
                    maxLength = Math.max(maxLength, mySet.size());
                    right++;
                } else {
                    mySet.remove(s.charAt(left));
                    left++;
                }
        }
        return maxLength;
    }
}
