package Day00;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoIterator {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("Audi");
        cars.add("Toyota");
        cars.add("Mazda");
        cars.add("BMW");

        Iterator<String> it = cars.iterator();
        System.out.println(it);
        System.out.println(it.next());
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(12);
        nums.add(8);
        nums.add(28);
        nums.add(0);
        nums.add(6);
        Iterator<Integer> it1 = nums.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
            Integer i = it1.next();
            if (i < 10) {
                it1.remove();
            }
        }
        System.out.println(nums);
    }

}
