package Day292;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static int getLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int getLongest(String s) {
        //cc
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (set.add(c)) {
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static int getLongestI(String s) {
        //cc
        int max = 0;
        String test = "";
        for (char c : s.toCharArray()) {
            String cur = String.valueOf(c);
            if (test.contains(cur)) {
                test = test.substring(test.indexOf(cur) + 1);
            }
            test += cur;
            max = Math.max(max, test.length());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("jinweihustonehoo"));
        System.out.println(getLongest("jinweihustonehoo"));
        System.out.println(getLongestI("jinweihustonehoo"));
    }
}
