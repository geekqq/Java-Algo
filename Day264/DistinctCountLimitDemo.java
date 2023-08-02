package Day264;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
