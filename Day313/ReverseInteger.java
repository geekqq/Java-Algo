package Day313;

public class ReverseInteger {

    public static long reverseInteger(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        int x = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            x = x * 10 + lastDigit;
            n /= 10;
        }
        return isNeg ? x * (-1) : x;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(1234));
        System.out.println(reverseInteger(-1234));
    }
}
