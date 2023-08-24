package Day280;

import static Day263.ReverseString.swap;

public class ReverseInteger {

    public static long reverseInt(int n) {
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        long reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n /= 10;
        }
        return isNeg ? reverse * -1 : reverse;
    }

    public static long reverseIntI(int n) {
        String num = String.valueOf(n);
        String reversedStr;
        if (n < 0) {
            reversedStr = "-" +  reverseStr(num.substring(1));
        } else {
            reversedStr = reverseStr(num);
        }
        return Long.valueOf(reversedStr);
    }

    public static String reverseStr(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i++, j--);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(12324));
        System.out.println(reverseInt(-12324));
        System.out.println(reverseIntI(12423));
        System.out.println(reverseIntI(-12423));
    }
}
