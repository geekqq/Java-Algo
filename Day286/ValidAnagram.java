package Day286;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static boolean isAnagramFreq(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            freq[pos] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i) - 'a';
            freq[pos] --;
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
        System.out.println(isAnagramMap(s, t));
        System.out.println(isAnagramMap(s1, t1));
        System.out.println(isAnagramFreq(s, t));
        System.out.println(isAnagramFreq(s1, t1));
    }
}
