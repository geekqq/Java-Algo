package Day252;

import java.util.*;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("1");

        System.out.println(set.stream().findFirst().get());
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(4);
        System.out.println(findSingleNumber(arr));
        String str = "Hello planet earth, you are a great planet";
        System.out.println(str.indexOf("planet"));
        System.out.println(str.lastIndexOf("planet"));
        System.out.println(str.lastIndexOf("e", 5));
        System.out.println(str.lastIndexOf('t', 36));
    }

    public static int findSingleNumber(List<Integer> arr) {

        for (Integer a : arr) {
            if (arr.indexOf(a) == arr.lastIndexOf(a)) {
                return a;
            }
        }
        return -1;
    }

}
