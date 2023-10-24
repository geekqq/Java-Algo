package Day326;

import static Day321.CharacterReplacement.characterRePlacement;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < s.length()) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l++) - 'A']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterRePlacement("AABBABA", 2));
    }
}
