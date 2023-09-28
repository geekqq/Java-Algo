package Day310;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {

    public static int longestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static int longestSubstringI(String s) {
        //cc
        int l = 0;
        int r = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.add(c)) {
                res = Math.max(res, set.size());
                r++;
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return res;
    }

    public static int longestSubstringII(String s) {
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
        System.out.println(longestSubstring("jinweihustonehoo"));
        System.out.println(longestSubstringI("jinweihustonehoo"));
        System.out.println(longestSubstringII("jinweihustonehoo"));
    }
}
