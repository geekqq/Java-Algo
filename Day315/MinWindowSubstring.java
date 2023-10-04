package Day315;

public class MinWindowSubstring {

    public static String minWindowSubstring(String s, String t) {
        if (s == null || t == null) return null;
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int l = 0;
        int start = 0;
        int total = t.length();
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            if (count[s.charAt(r)]-- > 0) total--;
            while (total == 0) {
                int len = r - l + 1;
                if (minLen > len) {
                    minLen = len;
                    start = l;
                }
                if (++count[s.charAt(l++)] > 0) total++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));

    }
}
