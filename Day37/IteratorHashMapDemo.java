package Day37;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class IteratorHashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1st");
        map.put("2", "2nd");
        map.put("3", "3rd");
        Collection cl = map.values();
        Iterator it = cl.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
