package Day268;

public class BinaryToInt {

    public static int binaryToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int digit  = Integer.parseInt(String.valueOf(c));
            res += digit * Math.pow(2, s.length() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binaryToInt("111"));
        System.out.println(Math.pow(2, 0));
    }
}
