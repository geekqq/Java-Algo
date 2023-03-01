package Day180;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1323));
    }

    private static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            int remainder = n % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            reverse = reverse * 10 + remainder;
            n /= 10;
        }
        return reverse;
    }
}
