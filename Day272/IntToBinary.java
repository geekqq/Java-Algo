package Day272;

public class IntToBinary {

    public static String intToBinary(int n) {
        // ignore the negative numbers;

        String res = "";
        if (n == 0) return "0";
        while (n > 0) {
            int remainder = n % 2;
            res = remainder + res;
            n /= 2;
        }
        return res;
    }

    public static int binaryToInt(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int power = s.length() - 1 - i;
            res += digit * Math.pow(2, power);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intToBinary(40));
        System.out.println(binaryToInt("101000"));
    }
}
