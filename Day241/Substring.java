package Day241;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 0) {
            System.out.println(" A is lexicographically smaller than B");
        } else if (A.compareTo(B) < 0){
            System.out.println("A is lexicographically greater than B");
        } else {
            System.out.println("A is equal to B");
        }
        System.out.println(capitalized(A) + " " + capitalized(B));
    }

    private static String capitalized(String s) {
        if (s == null || s.length() == 0) return null;
        String firstLetter = s.substring(0, 1).toUpperCase();
        String restLetters = s.substring(1);
        return firstLetter + restLetters;
    }
}
