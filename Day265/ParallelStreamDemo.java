package Day265;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamDemo {


}

class Student {
    String name;
    int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("stone", 98),
                new Student("ming", 88),
                new Student("gary", 68),
                new Student("hao", 78),
                new Student("joy", 88),
                new Student("ai", 58),
                new Student("yong", 80)
        );

        students.stream().filter(stu -> stu.getScore() >= 80)
                .map(Student::getName)
                .forEach(n -> System.out.println(n));

        students.stream().filter(stu -> stu.getScore() >= 80).limit(3)
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        students.parallelStream().filter(s -> s.getScore() >= 80).limit(3)
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        students.stream().parallel().filter(s -> s.getScore() >= 80).limit(3)
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}