package Day10;

import java.util.LinkedList;

public class DemoLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Google");
        list.add("Yahoo");
        list.add("Facebook");
        list.add("Twitter");
        System.out.println(list);
        list.addFirst("Apple");
        System.out.println(list);
        list.addLast("Amazon");
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println("--------------");
        for (String i : list) {
            System.out.println(i);
        }
    }
}
