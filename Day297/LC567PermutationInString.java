package Day297;

public class LC567PermutationInString {

    public static boolean permutationInString(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if (lenS1 > lenS2) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (int i = 0; i < lenS1; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= lenS2 - lenS1; i++) {
            if (i != 0) {
                countS2[s2.charAt(i + lenS1 - 1) - 'a']++;
                countS2[s2.charAt(i - 1) - 'a']--;
            }
            if (isAnagram(countS1, countS2)) return true;
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
        System.out.println(permutationInString("ab", "eidbaooo"));
        System.out.println(permutationInString("ab", "eidboaooo"));
    }
}
