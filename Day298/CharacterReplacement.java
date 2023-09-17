package Day298;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int res = 0;
        int[] count = new int[26];
        while (r < s.length()) {
            char c = s.charAt(r);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);
            while (r - l + 1 - maxFreq > k) {
                char ch = s.charAt(l++);
                count[ch - 'A']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
}
