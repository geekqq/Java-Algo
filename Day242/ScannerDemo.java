package Day242;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s0 = sc.next();
//        String s1 = sc.next();
//        System.out.println(s0);
//        System.out.println(s1);
//        sc.close();
        String s = "Facebook.com \n JavaTpoint.com 22 60.0";
        Scanner scanner = new Scanner(s);
        System.out.println("token1: " + scanner.next());
        System.out.println("token2: " + scanner.next());
        System.out.println("token3: " + scanner.next());
        System.out.println("token4: " + scanner.next());
    }
}
