package Day240;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringIndexOf {

    public static void main(String[] args) {
        String s = "88 99 200";
        System.out.println(s.substring(0, s.indexOf(' ')));
        int first = s.indexOf(' ');
        int second = s.indexOf(" ", first + 1);
        System.out.println(s.substring(first + 1, second));
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(3, "three");
        map.put(4, "four");
        map.put(2, "two");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());

        }
        List<Integer> res = new ArrayList<>();
        for (int id : map.keySet()) {
            if (id > 2) {
                res.add(id);
            }
        }
        System.out.println(res);
    }
}
