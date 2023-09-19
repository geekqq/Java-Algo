package Day299;

public class PermutationString {

    public static boolean isPermutationString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < l1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= l2 - l1; i++) {
            if (i != 0) {
                count2[s2.charAt(i + l1 - 1) - 'a']++;
                count2[s2.charAt(i - 1) - 'a']--;
            }
            if (isAnagram(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnagram(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationString("ab", "eidbaooo"));
        System.out.println(isPermutationString("ab", "eidboaooo"));
    }
}
