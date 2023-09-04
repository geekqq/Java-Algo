package Day286;

public class ReverseInteger {

    public static long reverseInteger(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        int rev = 0;
        while (n > 0) {
            int lastDig = n % 10;
            rev = rev * 10 + lastDig;
            n /= 10;
        }
        return isNeg ? rev * -1 : rev;
    }


    public static void main(String[] args) {
        System.out.println(reverseInteger(23345));
        System.out.println(reverseInteger(-23345));
    }
}
