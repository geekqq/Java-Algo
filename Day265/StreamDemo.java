package Day265;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,1,3,5,8,7);
        List<Integer> integers = list.stream().sorted().collect(Collectors.toList());
        System.out.println(integers);
        list.stream().sorted().forEach(n -> System.out.print(n + " "));
    }
}
