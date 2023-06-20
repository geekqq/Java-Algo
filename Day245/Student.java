package Day245;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Student {
    private int id;
    private String name;
    private double cgpa;

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(
                Comparator.comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId)
        );
        for (String event : events) {
            String[] parts = event.split("\\s+");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                queue.add(student);
            } else if (parts[0].equals("SERVED")) {
                queue.poll();
            }
        }
        List<Student> students = new ArrayList<>(queue);
        students.sort(Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId));
        return students;

    }
}
