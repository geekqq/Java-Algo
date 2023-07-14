package Day259;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 4, 6, 8, 10, 9, 1, 15, 2);
        Predicate<Integer> predicate = (t) -> {
            return t > 4;
        };
        list.stream().filter(predicate).sorted().forEach(t -> System.out.println(t));
    }
}
