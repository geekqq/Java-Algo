package Day287;

import java.util.HashMap;
import java.util.Map;

public class GetLongestSubstringWithoutDuplicates {


    public static int getLongest(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
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

    public static void main(String[] args) {
        System.out.println(getLongest("abbc"));
        System.out.println(getLongest("tmmxuct"));
    }
}
