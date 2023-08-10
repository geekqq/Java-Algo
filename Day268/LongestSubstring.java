package Day268;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int getLength(String s) {
        //cc
        int left =0;
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

    public static int getLengthI(String s) {
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
        System.out.println(getLength("jinweihustonehoo"));
        System.out.println(getLengthI("jinweihustonehoo"));
    }
}
