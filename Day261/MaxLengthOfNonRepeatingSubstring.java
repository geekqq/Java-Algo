package Day261;

import java.util.HashSet;
import java.util.Set;

public class MaxLengthOfNonRepeatingSubstring {

    public static int getMaxLength(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.add(s.charAt(right++))) {
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static int getMaxLengthI(String s) {
        if (s == null || s.length() == 0) return 0;
        String test = "";
        int maxLen = 0;
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
        System.out.println(getMaxLength("jinweihustonehoo"));
        System.out.println(getMaxLengthI("jinweihustonehoo"));
    }
}
