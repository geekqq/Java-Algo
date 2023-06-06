package Day239;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {

    public static int getLength(String s) {
        if (s == null || s.length() == 0) return -1;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
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

    public static void main(String[] args) {
        System.out.println(getLength("jinwiehuStonehoo"));
    }
}
