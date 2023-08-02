package Day264;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static void main(String[] args) {
        //map returns a single object
        //flatmap returns multiple objects which is a stream
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> integers = list.stream().map(n -> n + 10).collect(Collectors.toList());
        System.out.println(integers);

        System.out.println("=============================");
        List<Integer> list1 = Arrays.asList(1,2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(5,6);

        List<List<Integer>> collection = new ArrayList<>();
        collection.add(list1);
        collection.add(list2);
        collection.add(list3);
        System.out.println(collection);
        List<Integer> result = collection.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(result);
        List<Integer> integers1 = collection.stream().flatMap(x -> x.stream().map(n -> n + 10)).collect(Collectors.toList());
        System.out.println(integers1);
        collection.stream().flatMap(x -> x.stream().map(n -> n + 10)).forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("=============================");

        List<String> teamA = Arrays.asList("Scott", "David", "John");
        List<String> teamB = Arrays.asList("Mary", "Luna", "Tom");
        List<String> teamC = Arrays.asList("Ken", "Johny", "Kitty");
        List<List<String>> players = Arrays.asList(teamA, teamB, teamC);
        System.out.println(players);
        players.stream().flatMap(x -> x.stream()).forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println("============before JAVA 8==================");
        for (List<String> team : players) {
            for (String n : team) {
                System.out.print(n + ", ");
            }
        }
    }
}
