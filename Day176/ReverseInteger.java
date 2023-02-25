package Day176;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(123442342));
        System.out.println(reverseInteger(0));
    }

    private static int reverseInteger(int x) {
        //if (x == 0) return 0;
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && pop > -8) return 0;
            res = res * 10 + pop;
        }
        return res;
    }
}
