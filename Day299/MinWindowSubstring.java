package Day299;

public class MinWindowSubstring {

    public static String minWindowSubstring(String s, String t) {
        if (s == null || t == null) return "";
        if (s.length() == 0 || t.length() == 0) return "";
        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int total = t.length();
        int start = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (freq[c]-- > 0) total--;
            while (total == 0) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    start = l;
                }
                if (++freq[s.charAt(l++)] > 0) total++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring("a", "a"));
        System.out.println(minWindowSubstring("a", "aa"));
    }
}
