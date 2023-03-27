package Day201;

import java.util.*;

public class SortCharacterByFrequency {

    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (c1, c2) -> map.get(c1) == map.get(c2) ? c1.compareTo(c2) : map.get(c2) - map.get(c1));
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}