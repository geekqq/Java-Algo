package Day282;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutDuplicates {

    public static int getLongestSubString(String s) {
        if (s == null || s.length() == 0) return -1;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxLen = Math.max(maxLen, set.size());
                right++;
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static int getLongestSubStringI(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException();
        int maxLen = 0;
        String test = "";
        for (char c : s.toCharArray()) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubString("jinweihustonehoo"));
        System.out.println(getLongestSubStringI("jinweihustonehoo"));
    }
}
