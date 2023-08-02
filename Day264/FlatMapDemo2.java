package Day264;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapDemo2 {
    public static void main(String[] args) {
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student("Smith", 101, 'A'));
        studentList1.add(new Student("John", 102, 'B'));
        studentList1.add(new Student("Kenny", 103, 'C'));

        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(new Student("Scott", 104, 'A'));
        studentList2.add(new Student("Mary", 105, 'B'));
        studentList2.add(new Student("Kitty", 106, 'C'));

        List<Student> studentList3 = new ArrayList<>();
        studentList3.add(new Student("Stone", 107, 'A'));
        studentList3.add(new Student("Joy", 108, 'B'));
        studentList3.add(new Student("Kyle", 109, 'C'));

        List<List<Student>> students = Arrays.asList(studentList1, studentList2, studentList3);

        students.stream().flatMap(x -> x.stream().map(Student::getGrade)).forEach(n -> System.out.print(n + ", "));
    }
}

class Student {

    private String name;
    private int id;
    char grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public Student(String name, int id, char grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}
