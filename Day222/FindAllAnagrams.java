package Day222;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || s.length() < p.length()) return res;

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
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ba"));
    }
}
