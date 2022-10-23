package Day51;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihu"));
        System.out.println(getLengthOfSubstringLongest("jinweihu"));
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

    public static int getLengthOfSubstringLongest(String s) {
        int maxLen = 0;
        String test = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test += current;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }
}
