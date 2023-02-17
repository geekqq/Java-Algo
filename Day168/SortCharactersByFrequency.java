package Day168;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("jinweihustonehoo"));
    }

    private static String frequencySort(String s) {
        if (s == null || s.length() <= 2) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o1 - o2;
                }
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : map.keySet()) {
            pq.offer(c);
        }
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            int count = map.get(c);

            while (count-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
