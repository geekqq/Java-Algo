package Day00;

import java.util.HashSet;

public class DemoHashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("Audi");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        cars.add("Honda");
        System.out.println(cars);
        System.out.println(cars.contains("BMW"));
        System.out.println(cars.remove("Honda"));
        System.out.println(cars);
        System.out.println(cars.size());
        for (String i : cars) {
            System.out.println(i);
        }

        System.out.println("-------------");

        HashSet<Integer> nums = new HashSet<Integer>();
        nums.add(19);
        nums.add(1);
        nums.add(9);
        nums.add(4);
        System.out.println(nums);
        System.out.println(nums.contains(1));
        if (nums.contains(4)) {
            System.out.println("4 was found in the set");
        }
        System.out.println("--------------");

        for (int i = 0; i < nums.size(); i++) {
            if (nums.contains(i)) {
                System.out.println(i + " was found in the set");
            } else {
                System.out.println(i + " was not found in the set");
            }
        }

    }
}
