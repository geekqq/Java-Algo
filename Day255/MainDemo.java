package Day255;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDemo {

    public static void main(String[] args) {
        List<String> strings = new ArrayList();

        strings.add("Hello");
        strings.add("World");

        String hello = strings.get(0);
        String world = strings.get(1);
        System.out.println(hello + " " + world);

        Pair<Person> people = new Pair<>(new Person("Richard"), new Person("Stone"));
        System.out.println(people);
        List<String> list = List.of("Hello", "World");
        List<Integer> anotherList = List.of(1,2,3,4,5,6);
        System.out.println(reverse(list));
        System.out.println(list);
        System.out.println(anotherList);
        System.out.println(reverse(anotherList));
    }

    public static <T> List<T> reverse(List<T> originalList) {
        List<T> reversedList = new ArrayList<>(originalList);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
