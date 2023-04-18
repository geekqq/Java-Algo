package Day214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    // this is not correct!!!!
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() > s.length()) return res;
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (checkPattern(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean checkPattern(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] pattern = new int[26];
        for (char s : s1.toCharArray()) {
            pattern[s - 'a']++;
        }
        for (char s : s2.toCharArray()) {
            pattern[s - 'a']--;
        }
        for (int i : pattern) {
            if (i != 0) return false;
        }
        return true;
    }

    public static List<Integer> findAnagramsI(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int m = s.length(), n = p.length();
        int[] sc = new int[26];
        int[] pc = new int[26];

        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            pc[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            sc[s.charAt(i) - 'a']++;
            if (i >= n) sc[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(sc, pc)) res.add(i - n + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findAnagramsI("cbaebabacd", "abc"));
        System.out.println(findAnagramsI("abab", "ba"));
    }
}
