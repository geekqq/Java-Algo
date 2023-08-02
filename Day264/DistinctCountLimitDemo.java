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
        vehicle.stream().limit(3).forEach(n -> System.out.print(n + " "));
    }
}
