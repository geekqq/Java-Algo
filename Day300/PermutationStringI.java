package Day300;

import java.util.Arrays;

public class PermutationStringI {

    public static boolean permutationString(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) return false;
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i <= lenT - lenS; i++) {
            String subStr = t.substring(i, i + lenS);
            if (isAnagram(s, subStr)) return true;
        }
        return false;
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }


    public static boolean permutationSubstring(String s1, String s2) {
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
                countS2[s2.charAt(i + l1 - 1) - 'a']++; // add one element from right;
                countS2[s2.charAt(i - 1) - 'a']--; // remove one element from left;
            }
            if (isAnagramCount(countS1, countS2)) return true;
        }
        return false;
     }

     private static boolean isAnagramCount(int[] count1, int[] count2) {
         return Arrays.equals(count1, count2);
     }
    public static void main(String[] args) {
        System.out.println(permutationString("ab", "eidbaooo"));
        System.out.println(permutationSubstring("ab", "eidbaooo"));
        System.out.println(permutationString("ab", "eidboaooo"));
        System.out.println(permutationSubstring("ab", "eidboaooo"));
    }
}
