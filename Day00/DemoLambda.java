package Day00;

import java.util.ArrayList;
import java.util.function.Consumer;

public class DemoLambda {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.add(0);
        numbers.add(3);
        Consumer<Integer> method = (n) -> {
            System.out.println(n);
        };
        numbers.forEach(method);
    }
}
