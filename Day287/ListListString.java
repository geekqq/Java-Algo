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

        List<String> list3 = new LinkedList<>();
        List<String> list4 = new LinkedList<>();
        list3.add("list3");
        list4.add("list3");
        System.out.println(list3 == list4);
        System.out.println(list3.equals(list4));
        System.out.println("==== integer list equals====");
        List<Integer> list5 = new LinkedList<>();
        List<Integer> list6 = new LinkedList<>();
        list5.add(3);
        list6.add(3);
        System.out.println(list5 == list6);
        System.out.println(list5.equals(list5));
        System.out.println("====char and int====");
        System.out.println(10 - '1');
        System.out.println((Integer.valueOf('5' - '1')));
        System.out.println((Integer.valueOf('0')));

    }
}
