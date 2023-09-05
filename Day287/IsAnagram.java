package Day287;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            int pos = c - 'a';
            freq[pos]++;
        }
        for (char c : t1.toCharArray()) {
            int pos = c - 'a';
            freq[pos]--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s1 = "rat", t1 = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s1, t1));

    }
}

