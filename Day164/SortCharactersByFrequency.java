package Day164;

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 2) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //sort with heap
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (map.get(c1) == map.get(c2)) {
                    return c1 - c2;
                }
                return map.get(c2) - map.get(c1);
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

    public static String frequencySortII(String s) {
        if (s == null || s.length() <= 2) return s;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(count.keySet());
        Collections.sort(chars, (a, b) -> count.get(b) - count.get(a)); // 按照char的frequency降序排列

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int appear = count.get(c);
            while (appear-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("abcsazssaddsa"));
        System.out.println(frequencySortII("tree"));
    }
}
