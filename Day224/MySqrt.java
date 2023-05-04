package Day224;

public class MySqrt {

    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x < 2) return x;
        int left = 2;
        int right = x / 2;
        int res = 0;
        while (left <= right) {
            res = left + (right - left) / 2;
            if (res == x / res) return res;
            else if (res < x / res) left = res + 1;
            else right = res - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "sqrt = " + mySqrt(i) + ",");
        }
    }
}
