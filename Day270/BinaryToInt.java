package Day270;

public class BinaryToInt {

    public static int binaryToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            res += digit * Math.pow(2, s.length() - 1 - i);
        }
        return res;
    }

    public static int binaryToIntI(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int power = s.length() - 1 - i;
            res += digit << power;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binaryToIntI("111"));
    }
}
