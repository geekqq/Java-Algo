package Day259;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaTest {
    public static void main(String[] args) {
//        Runnable;
//        Callable;
//        Comparator
// new function interface introduced in java 8;
//        Function;
//        Supplier;
//        Predicate;
//        Consumer;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable run = () -> {
            System.out.println("Run method");
        };

//        MyFunction test = (i) -> System.out.println("test method executed ...");
//        test.test(15);

        MyFunction function = (i) -> {
            return i * 10;
        };
        System.out.println(function.test(15));

        NewFunction function1  = (s1, s2) -> {
            return s1 + ":" + s2;
        };
        System.out.println(function1.test("hello ", " world"));

        List<User> users = Stream.of(
                new User("Hoo", "12345678", Arrays.asList("hoo@mail.com", "hao@mail.com")),
                new User("Hao", "51023733", Arrays.asList("hao@gmail.com", "hoo@gmail.com")))
                .collect(Collectors.toList());
        List<List<String>> emails = users.stream().map(User::getEmail).collect(Collectors.toList());
        System.out.println(emails);
        List<String> phoneNumbers = users.stream().map(User::getPhone).collect(Collectors.toList());
        System.out.println(phoneNumbers);
        List<String> userNames = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(userNames);

        // flatMap will be used under ONE TO MANY senerio;
        List<String> userEmails = users.stream().flatMap(u -> u.getEmail().stream()).collect(Collectors.toList());
        System.out.println(userEmails);
    }
}
