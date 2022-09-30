package Day06;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(1);
        mySet.add(1);
        System.out.println(mySet.add(1));
    }

}
