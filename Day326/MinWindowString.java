package Day326;

public class MinWindowString {

    public static String minWindowSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return "null";
        int[] freq = new int[128];
        for (char c : s2.toCharArray()) {
            freq[c]++;
        }
        int l = 0;
        int start = 0;
        int total = s2.length();
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s1.length(); r++) {
            if (freq[s1.charAt(r)]-- > 0) total--;
            while (total == 0) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    start = l;
                }
                if (++freq[s1.charAt(l++)] > 0) total++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "null" : s1.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring("a", "a"));
        System.out.println(minWindowSubstring("a", "aa"));
    }
}
