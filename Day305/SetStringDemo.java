package Day305;

import java.util.HashSet;
import java.util.Set;

public class SetStringDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add('A' + " is seen in rows " + 1);
        System.out.println(set);
        System.out.println(set.add('A' + " is seen in rows " + 1));
        System.out.println('A' + " is a String " + 12 + " 23");
    }
}
