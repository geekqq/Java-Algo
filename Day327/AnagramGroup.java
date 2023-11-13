package Day327;

import java.util.*;

public class AnagramGroup {
    public static List<List<String>> anagramGroup(String[] words) {
        if (words == null || words.length == 0) return null;
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
            if (list.size() == 1) res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat", "tab", "eta"};
        System.out.println(anagramGroup(strs));
    }
}
