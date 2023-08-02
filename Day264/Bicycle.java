package Day264;

import java.util.Arrays;
import java.util.List;

public class Bicycle {
    public static void main(String[] args) {
        List<String> bicycle = Arrays.asList("bus", "car", "bicycle", "flight", "train");
        bicycle.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));
        bicycle.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
        System.out.println("=====");
        bicycle.stream().map(n -> n + " is red").forEach(System.out::println);

        System.out.println("-=======----");

        List<Integer> number = Arrays.asList(2, 3,1, 4,7,5, 6);
        number.stream().map(n -> n * 3).forEach(System.out::println);
        number.stream().map(n -> n * 3) .forEach(n -> System.out.print(n + " "));
    }
}
