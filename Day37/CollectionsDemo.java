package Day37;

import java.util.HashSet;
import java.util.Iterator;

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("集合实例！\n"); //\n表示隔行打印
        int size;
        HashSet collection = new HashSet();
        String str1 = "yellow";
        String str2 = "white";
        String str3 = "blue";
        String str4 = "green";
        collection.add(str1);
        collection.add(str2);
        collection.add(str3);
        collection.add(str4);
        System.out.print("集合数据为：");
        Iterator iterator;
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        size = collection.size();
        if (collection.isEmpty()) {
            System.out.println("集合是空的。");
        } else {
            System.out.println("集合的长度为：" + size);
        }
    }
}
