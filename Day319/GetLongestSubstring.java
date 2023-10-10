package Day319;

import java.util.HashMap;
import java.util.Map;

public class GetLongestSubstring {

    public static int getLongest(String s) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
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

    public static void main(String[] args) {
        System.out.println(getLongest("jinweihustonehoo"));
    }
}
