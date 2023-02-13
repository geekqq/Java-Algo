package Day164;

import java.util.*;

public class TopKFrequentWords {
    //LC692
    public static List<String> topKFrequentWords(String[] words, int k) {
        List<String> res = new LinkedList<>();

        if (words == null || words.length == 0 || k <= 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o2.compareTo(o1);
                }
                return map.get(o1) - map.get(o2);
            }
        });

//        List<String> list = new ArrayList<>(map.keySet());
//        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        for (String str : map.keySet()) {
            pq.offer(str);

            while (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequentWords(strs, 4));
    }
}
