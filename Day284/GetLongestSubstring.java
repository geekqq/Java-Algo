package Day284;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetLongestSubstring {

    public static int getLongest(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static int getLongestI(String s) {
        if (s == null || s.length() == 0) return 0;
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
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static int getLongestII(String s) {
        if (s == null || s.length() == 0) return 0;
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

        System.out.println(getLongest("tmmzuxt"));
        System.out.println(getLongestI("tmmzuxt"));
        System.out.println(getLongestII("tmmzuxt"));
    }

}
