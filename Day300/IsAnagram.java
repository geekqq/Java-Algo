package Day300;

import java.util.Arrays;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freqT[c - 'a']++;
        }
        return Arrays.equals(freqS, freqT);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("tea", "ate"));
        System.out.println(isAnagram("liek", "kite"));
    }
}
