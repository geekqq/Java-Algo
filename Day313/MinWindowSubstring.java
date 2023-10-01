package Day313;

public class MinWindowSubstring {

    public static String minWindowSubstring(String s, String t) {
        if (s == null | t == null) return null;
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int start = 0;
        int total = t.length();
        for (int r = 0; r < s.length(); r++) {
            if (freq[s.charAt(r)]-- > 0) total--;
            while (total == 0) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    start = l;
                }
                if (++freq[s.charAt(l++)] > 0) total++;
            }
        }
        return minLen == Integer.MIN_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));

    }
}
