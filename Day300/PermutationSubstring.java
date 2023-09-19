package Day300;

public class PermutationSubstring {

    public static boolean permutationSubstring(String s, String t) {
        if (s == null  || t == null || s.length() > t.length()) return false;
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
                countT[t.charAt(i - 1 + l1) - 'a']++;
                countT[t.charAt(i - 1) - 'a']--;
            }
            if (isAnagram(countS, countT)) return true;
        }
        return false;
    }

    private static boolean isAnagram(int[] countS, int[] countT) {
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutationSubstring("ab", "eidbaooo"));
        System.out.println(permutationSubstring("ab", "eidboaooo"));
    }
}
