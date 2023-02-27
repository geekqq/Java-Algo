package Day178;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(frequentWords(words, 2));
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(frequentWords(words2, 4));
    }
    private static List<String> frequentWords(String[] words, int k) {
        if (words == null || words.length == 0) return null;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new LinkedList<>(map.keySet());
        Collections.sort(list, (w1, w2) -> map.get(w1) == map.get(w2) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return list.subList(0, k);
    }
}
