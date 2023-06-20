package Day246;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        PriorityQueue<Student> students = new PriorityQueue<>(num, new StComparator());
        String op;
        for (int i = 0; i < num; i++) {
            op = sc.next();
            if (op.equals("ENTER")) {
                students.add(new Student(sc.next(), sc.nextDouble(), sc.nextInt()));
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            } else if (op.equals("SERVED")) {
                students.poll();
            }
        }
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }

}

class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class StComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() > b.getCgpa()) {
            return -1;
        } else if (a.getCgpa() < b.getCgpa()) {
            return 1;
        } else {
            if (a.getName().compareTo(b.getName()) > 0) {
                return 1;
            } else if (a.getName().compareTo(b.getName()) < 0) {
                return -1;
            } else {
                if (a.getId() > b.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
