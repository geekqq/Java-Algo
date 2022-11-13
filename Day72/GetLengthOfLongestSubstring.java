package Day72;

import java.util.HashSet;
import java.util.Set;

public class GetLengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(getLength("helloworld!"));
        System.out.println(getLength2("helloworld!"));
    }

    public static int getLength(String s) {
        if (s.length() == 0 || s.isEmpty()) {
            return 0;
        }

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

    public static int getLength2(String s) {
        if (s.isEmpty() ||s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        String test = "";

        char[] chars = s.toCharArray();
        for (char c : chars) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test += current;
            maxLen = Math.max(maxLen, test.length());
        }
        return maxLen;
    }
}
