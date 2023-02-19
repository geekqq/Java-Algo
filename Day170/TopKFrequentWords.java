package Day170;

import Day28.InsertSort;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, 2));
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words2, 4));
    }

    private static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return null;
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s2.compareTo(s1);
                }
                return map.get(s1) - map.get(s2);
            }
        });
        for (String str : map.keySet()) {
            pq.offer(str);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(0,pq.poll());
        }
        return res;
    }
}
