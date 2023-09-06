package Day288;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicates {

    public static int getLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("jinweihustonehoo"));
    }
}
