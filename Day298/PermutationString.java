package Day298;

public class PermutationString {


    public static boolean permutationString(String s1, String s2) {
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
                countS2[s2.charAt(i + l1 - 1) - 'a']++;  // sliding window move to the right by one by adding the element to the right
                countS2[s2.charAt(i - 1) - 'a']--; // remove the element at left
            }
            if (isAnagram(countS1, countS2)) return true;
        }
        return false;
    }

    private static boolean isAnagram(int[] countS1, int[] countS2) {
        for (int i = 0; i < 26; i++) {
            if (countS1[i] != countS2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutationString("ab", "eidbaooo"));
        System.out.println(permutationString("ab", "eidboaooo"));
    }
}
