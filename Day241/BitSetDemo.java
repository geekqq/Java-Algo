package Day241;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        while (sc.hasNextLine() && M > 0) {
            String operationSet = sc.next();
            int num = sc.nextInt();
            int op2 = sc.nextInt();

            if (operationSet.equals("AND")) {
                if (num == 1 && op2 == 2) {
                    B1.and(B2);
                } else {
                    B2.and(B1);
                }
            } else if (operationSet.equals("SET")) {
                if (num == 1) {
                    B1.set(op2, true);
                } else {
                    B2.set(op2, true);
                }
            } else if (operationSet.equals("FLIP")) {
                if (num == 1) {
                    B1.flip(op2);
                } else {
                    B2.flip(op2);
                }
            } else if (operationSet.equals("OR")) {
                if (num == 1 && op2 == 2) {
                    B1.or(B2);
                } else {
                    B2.or(B1);
                }
            } else if (operationSet.equals("XOR")) {
                if (num == 1 && op2 == 2) {
                    B1.xor(B2);
                } else {
                    B2.xor(B1);
                }
            }
            M--;
            System.out.printf("%D %d\n", B1.cardinality(), B2.cardinality());
        }
        sc.close();
    }
}
