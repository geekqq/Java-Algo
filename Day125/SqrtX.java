package Day125;

public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(11));
    }
    public static int mySqrt(int n) {
        if (n < 2) {
            return n;
        }
        int left = 2;
        int right = n / 2;
        while (left <= right) {
            int res = left + (right - left) / 2;
            if (res == n/res) {
                return res;
            } else if (res > n/res) {
                right = res - 1;
            } else {
                left = res + 1;
            }
        }
        return right;
    }
}
