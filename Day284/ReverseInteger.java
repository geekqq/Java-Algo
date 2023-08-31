package Day284;

public class ReverseInteger {

    public static long reverseInteger(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        int res = 0;
        while (n > 0) {
            int lastDig = n % 10;
            res = res * 10 + lastDig;
            n /= 10;
        }
        return isNeg ? res * -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(-3234));
        System.out.println(reverseInteger(4523));
    }
}
