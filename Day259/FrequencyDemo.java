package Day259;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FrequencyDemo {

    public static void main(String[] args) {
        String name = "StoneHoo";
        Map<String, Long> countMap = Arrays.stream(name.split(""))
                .collect(
                        groupingBy(Function.identity(), counting())
                );
        System.out.println(countMap);
    }
}
