package Day241;

import java.util.BitSet;

public class BitDemo {

    public static void main(String[] args) {
        BitSet B1 = new BitSet(8);
        BitSet B2 = new BitSet(8);
        B1.set(1);
        B1.set(3);
        B1.set(5);
        B2.set(1);
        B2.set(2);
        B2.set(5);
        B2.set(6);
        System.out.println(B1);
        System.out.println(B2);
        System.out.println("------------");
        B1.and(B2);
        B2.and(B1);
        System.out.println(B1);
        System.out.println(B2);
        System.out.println("------------");
        B1.or(B2);
        B2.or(B1);
        System.out.println(B1);
        System.out.println(B2);
        System.out.println("------------");
        //xor will return the element in one set but not in both
        //also will do it in place, modify the instance
        B1.xor(B2);
        B2.xor(B1);
        System.out.println(B1);
        System.out.println(B2);
    }
}
