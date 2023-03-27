package Day202;

public class SqrtX {

    public static int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            int res = left + (right - left) / 2;
            if (res == x / res) {
                return res;
            } else if (res < x / res) {
                left = res + 1;
            } else {
                right = res - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        for (int i = 0; i <26; i++) {
            System.out.println(i + " mySqrt is " + mySqrt(i));
        }
    }
}
