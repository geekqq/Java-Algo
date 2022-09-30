package Day00;

import java.util.ArrayList;
import java.util.Collections;
public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("Benz");
        cars.add("Opel");
        cars.add("Toyota");
        cars.add("Honda");
        System.out.println(cars);
        System.out.println(cars.get(3));
        cars.set(0, "Audi");
        System.out.println(cars);
        cars.remove(1);
        System.out.println(cars);
        /*cars.clear();
        System.out.println(cars);*/
        System.out.println(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        System.out.println("---------------");
        for (String car : cars) {
            System.out.println(car);
        }
        Collections.sort(cars);
        System.out.println(cars);
        System.out.println("--------------");

        ArrayList<Integer> myNums = new ArrayList<>();
        myNums.add(12);
        myNums.add(15);
        myNums.add(8);
        myNums.add(33);
        myNums.add(34);
        myNums.add(34);
        myNums.add(0);
        myNums.add(98);
        System.out.println(myNums);
        Collections.sort(myNums);
        System.out.println(myNums);
        for (int i : myNums) {
            System.out.println(i);
        }



    }
}
