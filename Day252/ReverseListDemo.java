package Day252;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class ReverseListDemo {

    public static List<Integer> reverseList(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            swap(list, i, list.size() - i - 1);
        }
        return list;
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}
