package Day268;

public class IntToBinary {

    public static String intToBinary(int n) {
        if (n < 0) return null;
        String res = "";
        while (n > 0) {
            int remainder = n % 2;
            res = remainder + res;
            n /= 2;
        }
        return res;
    }

    public static int binaryToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = Integer.parseInt(String.valueOf(c));
            res += digit * Math.pow(2, s.length() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.print(intToBinary(i) + " ");
        }
        System.out.println();
        System.out.println(binaryToInt("1001"));
        System.out.println('2' - '0');
        System.out.println(binaryToIntI("1101"));
    }

    public static int binaryToIntI(String s) {
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            int power = length - 1 - i;

            res += digit << power;
        }
        return res;
    }

}
