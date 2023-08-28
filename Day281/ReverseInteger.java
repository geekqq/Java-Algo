package Day281;

public class ReverseInteger {

    public static long reverseInteger(int n) {
        boolean isNegative = n < 0;
        if (isNegative) {
            n = n * -1;
        }
        long reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n /= 10;
        }
        return isNegative ? reverse * -1 : reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(-2321));
        System.out.println(reverseInteger(23321));
    }
}
