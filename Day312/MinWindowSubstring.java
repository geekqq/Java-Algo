package Day312;

public class MinWindowSubstring {

    public static String minWindowSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int[] count = new int[128];
        for (char c : s2.toCharArray()) {
            count[c]++;
        }
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int total = s2.length();
        int start = 0;
        for (int r = 0; r < s1.length(); r++) {
            if (count[s1.charAt(r)]-- > 0) total--;
            while (total == 0) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
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
