package Day311;

public class MinSubstringWindow {

    public static String minWindowSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        int[] freq = new int[128];
        for (char c : s2.toCharArray()) {
            freq[c]++;
        }
        int l = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int total = s2.length();
        for (int r = 0; r < s1.length(); r++) {
            char c = s1.charAt(r);
            if (freq[c]-- > 0) total--;
            while (total == 0) {
                if (min > r - l + 1) {
                    min = r - l + 1;
                    start = l;
                }
                if (++freq[s1.charAt(l++)] > 0) total++;
            }

        }
        return min == Integer.MAX_VALUE ? "" : s1.substring(start, start + min);
    }

    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
    }
}
