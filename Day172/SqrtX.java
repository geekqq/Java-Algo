package Day172;

public class SqrtX {
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            System.out.println(i + " sqrt = " + mySqrtX(i));
        }
    }

    private static int mySqrtX(int n) {
        if (n <= 1) return n;
        int left = 2;
        int right = n / 2;
        while (left <= right) {
            int res = left + (right - left) / 2;
            if (res == n / res) return res;
            else if (res < n / res) left = res + 1;
            else right = res - 1;
        }
        return right;
    }
}
