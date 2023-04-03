package Day206;

public class ReverseInteger {

    public static int reverseInteger(int x) {
        int reverse = 0;
        while (x != 0) {
            int remainder = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            reverse = reverse * 10 + remainder;
            x /= 10;
        }
        return reverse;
    }


    public static void main(String[] args) {
        System.out.println(reverseInteger(0));
        System.out.println(reverseInteger(10));
        System.out.println(reverseInteger(123));
    }
}
