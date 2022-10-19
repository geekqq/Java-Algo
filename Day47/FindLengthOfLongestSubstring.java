package Day47;

import java.util.HashSet;
import java.util.Set;

public class FindLengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("heworld!"));
        System.out.println(getLengthOfSubstring("heworld!"));
    }

    public static int getLengthOfLongestSubstring(String s) {
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

    public static int getLengthOfSubstring(String s) {
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

}
