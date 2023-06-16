package Day243;

import java.math.BigInteger;
import java.util.Scanner;

public class BiIntegerDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger sum = a.add(b);
        BigInteger multiple = a.multiply(b);
        System.out.println(sum);
        System.out.println(multiple);
    }
}
