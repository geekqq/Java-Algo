package Day318;

import java.util.Arrays;

import static Day228.ValidAnagram.isAnagram;

public class PermutationSubstring {

    public static boolean permutationSubstring(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() > t.length()) return false;
        int[] countS = new int[26];
        int[] countT = new int[26];
        int l1 = s.length();
        int l2 = t.length();
        for (int i = 0; i < l1; i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= l2 - l1; i++) {
            if (i != 0) {
                countT[t.charAt(i + l1 - 1) - 'a']++;
                countT[t.charAt(i - 1) - 'a']--;
            }
            if (Arrays.equals(countT, countS)) return true;
        }
        return false;
    }

    public static boolean permutationSubstringI(String s, String t) {
        if (s == null || t == null) return false;
        int l1 = s.length();
        int l2 = t.length();
        for (int i = 0; i <= l2 - l1; i++) {
            String subStr = t.substring(i, i + l1);
            if (isAnagram(s, subStr)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(permutationSubstring("ab", "eibaooo"));
        System.out.println(permutationSubstring("ab", "eiboaooo"));
        System.out.println(permutationSubstringI("ab", "eibaooo"));
        System.out.println(permutationSubstringI("ab", "eiboaooo"));
        System.out.println(permutationSubstring("ho", "stonehoojuinwe"));
        System.out.println(permutationSubstringI("ho", "stonehoojuinwe"));
    }
}
