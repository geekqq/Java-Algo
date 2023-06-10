package Day240;

import java.math.BigInteger;

public class TestBit {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("101"); //1010

        for (int i = 0; i < 32; i++) {
            boolean isSet = number.testBit(i);
            System.out.println(i + " " + isSet); //1100101
        }
    }
}
