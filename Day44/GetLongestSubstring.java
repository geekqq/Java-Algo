package Day44;

import java.util.HashSet;
import java.util.Set;

public class GetLongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("jinweihu"));
        System.out.println(getLengthOfLongestSubstring2("Jinweihu"));
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

    public static int getLengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        String test = "";
        char[] chars = s.toCharArray();

        for (char c : chars) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            maxLength = Math.max(maxLength, test.length());
        }
        return maxLength;
    }
}
