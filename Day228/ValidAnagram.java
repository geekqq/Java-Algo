package Day228;

import java.util.HashMap;
import java.util.Map;

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

    public static boolean isAnagramHashMap(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        s = s.toLowerCase();
        t = t.toLowerCase();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }
    public static void main(String[] args) {
        String s = "abcd";
        String t = "aacb";
        String p = "adcb";
        System.out.println(isAnagram("abcd", "aacb"));
        System.out.println(isAnagram("abcd", "adcb"));
        System.out.println(isAnagramHashMap(s, p));
    }
}
