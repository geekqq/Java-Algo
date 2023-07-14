package Day259;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 4, 6, 8, 10, 9, 1, 15, 2);
        Predicate<Integer> predicate = (t) -> {
            return t > 4;
        };
        list.stream().filter(predicate).sorted().forEach(t -> System.out.println(t));

        System.out.println("===============================");

        List<Employee> employees = Stream.of(
                new Employee(1, "Stone", "DEV", 50000),
                new Employee(2, "Hao", "DEV", 80000),
                new Employee(3, "Joy", "QA", 60000),
                new Employee(4, "Isaac", "QA", 90000),
                new Employee(5, "Ruien", "DEVOPS", 40000),
                new Employee(6, "Yong", "DEVOPS", 50000)
        ).collect(Collectors.toList());

        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> employeeMap = employees.stream().collect(
                groupingBy(Employee::getDept,
                        Collectors.reducing(BinaryOperator.maxBy(compareBySalary)))
        );
        System.out.println(employeeMap.toString());
        System.out.println("===============================");

        Map<String, Employee> employeeMap1 = employees.stream()
                .collect(groupingBy(Employee::getDept,
                        collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)
                        ));
        System.out.println(employeeMap1.toString());
    }
}
