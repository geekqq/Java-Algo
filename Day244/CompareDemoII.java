package Day244;


import java.util.*;

public class CompareDemoII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> studentList = new ArrayList<>();
        Checker checker = new Checker();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgba = sc.nextDouble();

            Student st = new Student(id, name, cgba);
            studentList.add(st);
        }
//        Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed()
//                .thenComparing(Student::getName)
//                .thenComparing(Student::getCgpa));

        Collections.sort(studentList, checker);
        for (Student st : studentList) {
            System.out.printf("%s\n", st.getName());
        }
    }
}

class Checker implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        double s1Cgba = s1.getCgpa();
        double s2Cgba = s2.getCgpa();
        String s1Name = s1.getName();
        String s2Name = s2.getName();
        int s1Id = s1.getId();
        int s2Id = s2.getId();
        if (s1Cgba > s2Cgba) {
            return -1;
        } else if (s1Cgba < s2Cgba) {
            return 1;
        } else if (s1Name.equals(s2Name)) {
            if (s1Id > s2Id) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return s1Name.compareTo(s2Name);
        }
    }
}

class Student {
    private String name;
    private int id;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getName() {
        return name;
    }
}