package Day228;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            freq[pos]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i) - 'a';
            freq[pos]--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abcd", "aacb"));
        System.out.println(isAnagram("abcd", "adcb"));
    }
}
