package Day242;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerPrimeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.nextLine());
        boolean bool = n.isProbablePrime(1);
        System.out.println(bool ? "prime" : "not prime");
        System.out.println("--------");
        for (int i = 0; i < 100; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            if (num.isProbablePrime(50)) {
                System.out.println(i + " is prime");
            }
        }
    }
}
