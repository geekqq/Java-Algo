package Day170;

import java.util.*;

public class SortCharacterByFrequencyII {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    private static String frequencySort(String s) {
        if (s == null || s.length() == 0) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

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
