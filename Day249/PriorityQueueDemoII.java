package Day249;

import java.util.*;

public class PriorityQueueDemoII {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    public static void main(String[] args) {

        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- > 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }

}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(new MyComparator());
        for (String event : events) {
            String[] arr = event.split(" ");
            String type = arr[0];

            if (type.equalsIgnoreCase("ENTER")) {
                String name = arr[1];
                double cgpa = Double.parseDouble(arr[2]);
                int id = Integer.parseInt(arr[3]);

                queue.add(new Student(name, cgpa, id));
            } else if (type.equalsIgnoreCase("SERVED")) {
                queue.poll();
            }
        }
        List<Student> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}

class Student {
    private String name;
    private double cgpa;
    private int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
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

class MyComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() < s2.getCgpa()) return 1;
        else if (s1.getCgpa() > s2.getCgpa()) return -1;
        else {
            int secondCompare = s1.getName().compareTo(s2.getName());
            if (secondCompare != 0) return secondCompare;
            else {
                int thirdCompare = s1.getId() - s2.getId();
                return thirdCompare;
            }
        }
    }
}