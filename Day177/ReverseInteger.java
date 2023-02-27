package Day177;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(13432423));
    }

    private static int reverse(int x) {
        int reverseNumber = 0;
        while (x != 0) {
            int remainder = x % 10;
            if (reverseNumber > Integer.MAX_VALUE / 10 || (reverseNumber == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reverseNumber < Integer.MIN_VALUE / 10 || (reverseNumber == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            reverseNumber = reverseNumber * 10 + remainder;
            x /= 10;
        }
        return reverseNumber;
    }
}
