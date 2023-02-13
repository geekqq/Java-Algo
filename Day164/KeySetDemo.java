package Day164;

import java.util.*;

public class KeySetDemo {
    public static void main(String[] args) {
        Map<Character, Integer> count = new HashMap<>();
        count.put('a', 1);
        count.put('c', 2);
        count.put('e', 3);
        count.put('z', 4);
        count.put('b', 5);
        List<Character> list = new ArrayList<>(count.keySet());
        Collections.sort(list, (a, b) -> count.get(a) - count.get(b));
        System.out.println(list);
    }
}
