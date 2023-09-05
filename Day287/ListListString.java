package Day287;


import java.util.LinkedList;
import java.util.List;

public class ListListString {

    public static void main(String[] args) {
        List<List<String>> res = new LinkedList<>();
        List<String> list = new LinkedList<>();
        list.add("hi");
        res.add(list);
        List<String> list2 = new LinkedList<>();
        list2.add("list2");
        res.add(list2);
        System.out.println(res);
        list.add("you");
        list2.add("element!");
        System.out.println(res);
    }
}
