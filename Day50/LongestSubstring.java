package Day50;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("dsaewqfdassdfaewq"));
        System.out.println(getLengthUsingSet("dsaewqfdassdfaewq"));
    }

    public static int getLengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String test = "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test += current;
            maxLength = Math.max(maxLength, test.length());
        }
        return maxLength;
    }
    public static int getLengthUsingSet(String s) {
        int maxlength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                maxlength = Math.max(maxlength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
}
