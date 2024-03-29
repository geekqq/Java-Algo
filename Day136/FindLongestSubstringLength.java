package Day136;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSubstringLength {
    public static void main(String[] args) {
        System.out.println(longestSubstring("jinweihustonehoo"));
        System.out.println(longestSubstring2("jinweihustonehoo"));
    }
    private static int longestSubstring(String s) {
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

    private static int longestSubstring2(String s) {
        int maxLen = 0;
        String test = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }
}
