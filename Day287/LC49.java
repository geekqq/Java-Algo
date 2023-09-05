package Day287;

import java.util.*;

public class LC49 {
    public static List<List<String>> anagramGroup(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(anagramGroup(strs));
        Map<String, Integer> map = new HashMap<>();
        map.put("stone", 1);
        map.put("joy", 5);
        map.put("kate", 3);
        map.put("john", 7);
        map.put("stone", 12);
        System.out.println(map.get("stone"));
        System.out.println(map.values());
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            freq[pos]++;
        }
        for (char c : t.toCharArray()) {
            int pos = c - 'a';
            freq[pos]--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }
}
