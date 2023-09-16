package Day297;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) throw new IllegalArgumentException("Invalid input");
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            countT[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("hello", "leloh"));
    }
}
