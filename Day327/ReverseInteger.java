package Day327;

public class ReverseInteger {

    public static int reverseInteger(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        int res = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            res = res * 10 + lastDigit;
            n /= 10;
        }
        return isNeg ? res * (-1) : res;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(1234));
        System.out.println(reverseInteger(-1234));
    }
}
