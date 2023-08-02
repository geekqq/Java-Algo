package Day264;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctCountLimitDemo {

    public static void main(String[] args) {
        // demo distinct() limit() count()
        List<String> vehicle = Arrays.asList("bus", "car", "bicycle", "bus", "car", "car", "bike");

        List<String> distinctVehicle = vehicle.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctVehicle);
        vehicle.stream().distinct().forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println(vehicle.stream().distinct().count());
        System.out.println(vehicle.stream().count());
        System.out.println(vehicle.size());
        vehicle.stream().distinct().limit(2).forEach(n -> System.out.print(n + " "));
        System.out.println("===========================");
        List<Integer> number = Arrays.asList(1, 2,3 ,4,5,6,7,8,9);

        long evenNumberCount = number.stream().filter(n -> (n & 1) == 0).count();
        System.out.println(evenNumberCount);
        System.out.println(number.stream().min((a, b) -> a - b).get());
        System.out.println(number.stream().max((a, b) -> a.compareTo(b)).get());
        System.out.println("===========================");

        //reduce()
        List<String> stringList = Arrays.asList("A", "B", "C", "D", "1", "2", "3", "4");
        Optional<String> reduce = stringList.stream().reduce((value, combinedValue) ->  value + combinedValue);
        System.out.println(reduce.get());
        Optional<String> reduce1 = stringList.stream().reduce((value, combinedValue) -> combinedValue + value);
        System.out.println(reduce1.get());
        Object[] array = stringList.stream().toArray();
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        for (Object v : array) {
            System.out.println(v);
        }
    }
}
