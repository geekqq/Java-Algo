package Day33;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "stonehoo";
        System.out.println(getLengthOfLongestSubstring(s));
        System.out.println(getLengthUsingTest(s));
        System.out.println(s.indexOf("o"));
        System.out.println(s.substring(8));
    }

    public static int getLengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

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

    public static int getLengthUsingTest(String s) {
        String test = "";
        int maxLength = 0;
        if (s.isEmpty()) {
            return 0;
        }

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }

            test += String.valueOf(c);
            maxLength = Math.max(maxLength, test.length());
        }
        return maxLength;
    }
}
