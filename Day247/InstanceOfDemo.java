package Day247;

import java.util.ArrayList;
import java.util.Scanner;

public class InstanceOfDemo {

    public static String count(ArrayList myList) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < myList.size(); i++) {
            Object element = myList.get(i);
            if (element instanceof Student) {
                a++;
            }
            if (element instanceof Rockstar) {
                b++;
            }
            if (element instanceof Hacker) {
                c++;
            }
        }
        String temp = Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c);
        return temp;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("Student")) list.add(new Student());
            if (s.equals("Rockstar")) list.add(new Rockstar());
            if (s.equals("Hacker")) list.add(new Hacker());
        }
        System.out.println(count(list));
    }
}
class Student {}
class Rockstar {}
class Hacker {}
