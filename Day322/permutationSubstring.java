package Day322;

import java.util.Arrays;

import static Day228.ValidAnagram.isAnagram;

public class permutationSubstring {

    public static boolean permutationSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
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

    public static boolean permutationSubstringI(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i <= l2 - l1; i++) {
            String subStr = s2.substring(i, i + l1);
            if (isAnagram(s1, subStr)) return true;
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
