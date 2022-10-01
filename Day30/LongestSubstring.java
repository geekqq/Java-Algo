package Day30;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "jinweihu";
        System.out.println(getLengthOfLongestSubstr(s));
        System.out.println(longestUniqueSubstr(s));
    }

    public static int getLengthOfLongestSubstr(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.add(s.charAt(right))) {
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static int longestUniqueSubstr(String s) {
        String test = "";

        //Result
        int maxLength = 0;
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);

            if (test.contains(current)) {
                test = test.substring((test.indexOf(current) + 1));
            }

            test += String.valueOf(c);
            maxLength = Math.max(maxLength, test.length());
        }
        return maxLength;
    }
}
