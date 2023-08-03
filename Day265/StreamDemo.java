package Day265;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,1,3,5,8,7);
        List<Integer> integers = list.stream().sorted().collect(Collectors.toList());
        System.out.println(integers);
        list.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));

        System.out.println("============================");
        List<String> list1 = Arrays.asList("Stone", "John", "Gary", "Ming", "Hao");
        list1.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
        list1.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));

        System.out.println("============================");
        Set<String> fruits = new HashSet<>();
        fruits.add("one apple");
        fruits.add("one banana");
        fruits.add("one apple");
        fruits.add("two grapes");
        fruits.add("more guavas");

        boolean one = fruits.stream().anyMatch(value -> value.startsWith("one"));
        System.out.println(one);

        boolean one1 = fruits.stream().allMatch(value -> value.startsWith("one"));
        System.out.println(one1);

        boolean one2 = fruits.stream().noneMatch(value -> value.startsWith("n"));
        System.out.println(one2);
    }
}
