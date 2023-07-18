package Day261;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 1, 6, 2, 7, 8, 10);
        Stream<Integer> data = nums.stream();
//        long count = data.count();
//        System.out.println(count);
        Stream<Integer> sortedData = data.sorted();
        sortedData.forEach(n -> System.out.print(n + " "));
        System.out.println();

        nums.stream()
                .map(n -> n * 2)
                .sorted()
                .forEach(m -> System.out.println(m));

        System.out.println(nums);
        nums.stream()
                .filter(n -> (n & 1) == 1)
                .map(n -> n * 2)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println(nums);
        int res = nums.stream()
                .filter(n -> (n & 1) == 1)
                .map(n -> n * 2)
                .reduce(0, (a, b) -> a + b);
        System.out.println(res);
    }

}
