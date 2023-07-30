package Day263;

import java.util.Collections;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.put(3, "A");
        treeMap.put(1, "C");
        treeMap.put(5, "D");
        treeMap.put(2, "A");
        System.out.println(treeMap);
    }
}
