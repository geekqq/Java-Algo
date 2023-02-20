package Day171;

import java.util.*;

public class TopKFrequentWord {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, 2));
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words2, 4));
    }

    private static List<String> topKFrequent(String[] strs, int k) {
        List<String> res = new LinkedList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word : strs) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (w1, w2) -> map.get(w1) == map.get(w2) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return list.subList(0, k);
    }
}
