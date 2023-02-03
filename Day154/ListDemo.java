package Day154;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        System.out.println(list1);
        System.out.println(list2);
        Set<List> set = new HashSet<>();
        System.out.println(set.add(list1));
        System.out.println(set.add(list2));

    }
}
