package Day223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() > s.length()) {
            return res;
        }
        int m = s.length();
        int n = p.length();
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
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ba"));
    }
}
