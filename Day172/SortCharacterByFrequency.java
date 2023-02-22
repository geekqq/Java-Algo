package Day172;

import java.util.*;

public class SortCharacterByFrequency {
    public static void main(String[] args) {
        System.out.println(frequentSort("tree"));
    }

    private static String frequentSort(String s) {
        if (s == null || s.length() == 0) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (c1, c2) -> map.get(c2) - map.get(c1));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
