package Day309;

public class MinWindowSubstring {

    public static String minWindowSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        int[] count = new int[128];
        for (char c : s2.toCharArray()) {
            count[c]++;
        }
        int l = 0;
        int total = s2.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s1.length(); r++) {
            char c = s1.charAt(r);
            if (count[c]-- > 0) total--;
            while (total == 0) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    start = l;
                }
                if (++count[s1.charAt(l++)] > 0) total++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s1.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
    }
}