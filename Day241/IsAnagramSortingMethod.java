package Day241;

import java.util.Arrays;

public class IsAnagramSortingMethod {
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "margana";
        System.out.println(isAnagram(s, t));
    }
}
