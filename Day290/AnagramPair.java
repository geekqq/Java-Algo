package Day290;

public class AnagramPair {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        int[] freq = new int[26];
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t1.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "sas"));
        System.out.println(isAnagram("tea", "eat"));
    }
}
