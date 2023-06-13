package Day241;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MyStringTokenizer {

    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        StringTokenizer st = new StringTokenizer(s, " !,?._'@");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        List<String> splits = Arrays.stream(s.split("[^A-Za-z]+")).map(s0 -> s0.trim())
                .filter(s0 -> !s0.isEmpty()).collect(Collectors.toList());
        System.out.println(splits.size());
        splits.stream().forEach(System.out::println);
    }
}
