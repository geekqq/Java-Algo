package Day263;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((a, b) -> b.compareTo(a));
        TreeSet<Integer> treeSet1 = new TreeSet<>(Collections.reverseOrder());

        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("F");
        treeSet.add("D");
        treeSet.add("C");
        treeSet.add("A");
        System.out.println(treeSet);
        System.out.println("===========");
        treeSet1.add(4);
        treeSet1.add(1);
        treeSet1.add(5);
        treeSet1.add(3);
        System.out.println(treeSet1);
    }
}
