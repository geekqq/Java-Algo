package Day296;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        char maxChar = '\0';
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            count[ch - 'A']++;
            if (maxChar == '\0' || count[ch - 'A'] > count[maxChar - 'A']) maxChar = ch;

            while ((end - start + 1) - count[maxChar - 'A'] > k) {
                char startChar = s.charAt(start++);
                count[startChar - 'A']--;

                if (startChar == maxChar) {
                    for (char c = 'A'; c <= 'Z'; c++) {
                        if (count[c - 'A'] > count[maxChar - 'A']) {
                            maxChar = c;
                        }
                    }
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int characterReplacementCount(String s, int k) {
        int res = 0;
        int l = 0;
        int r = 0;
        int[] count = new int[26];
        int maxFreq = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            count[c -'A']++;
            maxFreq = Math.max(maxFreq, count[c -'A']);
            while ((r - l + 1) - maxFreq > k) {
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
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacementCount("ABAB", 2));
        System.out.println(characterReplacementCount("AABABBA", 1));
    }
}
