package Day124;

public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(6));
    }
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            int res = left + (right - left) / 2;
            if (res == x / 2) {
                return res;
            } else if (res < x / res) {
                left = res + 1;
            } else {
                right = res - 1;
            }
        }
        return right;
    }
}
