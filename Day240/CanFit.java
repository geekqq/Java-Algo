package Day240;

import java.util.Scanner;

public class CanFit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= Math.pow(2, 7) * (-1) && x <= Math.pow(2, 7) - 1) {
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (x >= Math.pow(2, 15) * (-1) && x <= Math.pow(2, 15) - 1) {
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (x >= Math.pow(2, 31) * (-1) && x <= Math.pow(2, 31) - 1) {
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (x >= Math.pow(2, 63) * (-1) && x <= Math.pow(2, 63) - 1) {
                    System.out.println("* long");
                }
            }
            catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }
}
