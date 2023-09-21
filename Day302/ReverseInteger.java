package Day302;

public class ReverseInteger {

    public static long reverseInteger(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n /= 10;
        }
        return isNeg ? reverse * (-1) : reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(10123));
        System.out.println(reverseInteger(-10123));
    }
}
