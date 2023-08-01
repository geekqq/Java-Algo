package Day264;

import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    static class Vehicle{
        private int id;
        private String make;
        private int age;

        public Vehicle(int id, String make, int age) {
            this.id = id;
            this.make = make;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) {
        List<Vehicle> vehicleList = Arrays.asList(
                new Vehicle(1, "Tesla", 3),
                new Vehicle(2, "Audi", 1),
                new Vehicle(3, "BMW", 4),
                new Vehicle(4, "MCI", 2),
                new Vehicle(5, "Benz", 5)
        );
        vehicleList.stream().filter(v -> v.getAge() >= 3)
                .map(Vehicle::getMake)
                .forEach(System.out::println);
        long c = vehicleList.stream().filter(v -> v.getAge() >= 3).count();
        System.out.println(c);

        Map<Integer, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(1, new Vehicle(1, "Tesla", 3));
        vehicleMap.put(2, new Vehicle(2, "Audi", 1));
        vehicleMap.put(3, new Vehicle(3, "BMW", 4));
        vehicleMap.put(4, new Vehicle(4, "MCI", 2));
        vehicleMap.put(5, new Vehicle(5, "Benz", 5));

        Map<Integer, List<Vehicle>> vehicleMap2 = vehicleList.stream().collect(Collectors.groupingBy(Vehicle::getId));
        System.out.println(vehicleMap2);
//        vehicleMap2.entrySet().stream()
//                .filter(longListEntry -> longListEntry.getValue())
//                .map(Vehicle::getId)
//                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(10, 13, 12, 14, 15, 13, 20);
        for (Integer number : numbers) {
            if ((number & 1) == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
        numbers.stream().filter( n -> (n & 1) == 0).forEach(System.out::println);
        System.out.println("===========");
        numbers.stream().filter(n -> (n & 1) == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        numbers.stream().forEach(System.out::println);
        System.out.println("================");
        List<String> words = Arrays.asList("cup", null, "forest", null, "sky", "book", "teacher");
        List<String> res = new ArrayList<>();
        res = words.stream().filter(w -> w!=null).collect(Collectors.toList());
        System.out.println(res);
    }
}
