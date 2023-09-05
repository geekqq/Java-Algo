package Day287;

import java.util.*;

public class AnagramGroup {
    public static List<List<String>> anagramGroup(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new LinkedList<>(map.values());
    }

    public static List<List<String>> anagramGroups(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(word);
            map.put(key, list);
            if (list.size() == 1) {
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat", "tab"};
        System.out.println(anagramGroup(strs));
        System.out.println(anagramGroups(strs));
    }
}
