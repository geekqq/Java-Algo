package Day304;

import java.util.Arrays;

public class PermutationSubstring {

    public static boolean permutationSubstring(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i <= l2 - l1; i++) {
            String subStr = s2.substring(i, i + l1);
            if (isAnagram(s1, subStr)) return true;
        }
        return false;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            countS2[c - 'a']++;
        }
        return Arrays.equals(countS1, countS2);
    }

    public static boolean permutationSubstringI(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (int i = 0; i < l1; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= l2 - l1; i++) {
            if (i != 0) {
                countS2[s2.charAt(i + l1 - 1) - 'a']++;
                countS2[s2.charAt(i - 1) - 'a']--;
            }
            if (Arrays.equals(countS1, countS2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(permutationSubstring("ab", "eibaooo"));
        System.out.println(permutationSubstring("ab", "eiboaooo"));
        System.out.println(permutationSubstringI("ab", "eibaooo"));
        System.out.println(permutationSubstringI("ab", "eiboaooo"));
    }
}
