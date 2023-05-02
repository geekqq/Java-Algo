package Day223;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> count;
    HashMap<Integer, LinkedHashSet<Integer>> lists;

    int n;
    int minCount;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        count = new HashMap<>();
        lists = new HashMap<>();
        n = capacity;
        minCount = -1;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int cnt = count.get(key);
        count.put(key, cnt + 1);
        lists.get(cnt).remove(key);

        if (minCount == cnt && lists.get(cnt).size() == 0) minCount++;
        lists.putIfAbsent(cnt + 1, new LinkedHashSet<>());
        lists.get(cnt + 1).add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (n == 0) return;
        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);
            return;
        }
        if (map.size() == n) {
            int evictKey = lists.get(minCount).iterator().next();
            lists.get(minCount).remove(evictKey);
            map.remove(evictKey);
            count.remove(evictKey);
        }
        map.put(key, value);
        count.put(key, 1);
        minCount = 1;
        lists.putIfAbsent(1, new LinkedHashSet<>());
        lists.get(1).add(key);
    }
}
