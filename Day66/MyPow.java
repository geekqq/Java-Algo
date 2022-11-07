package Day66;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(MyPow(3,4));
        System.out.println(MyPowRe(3,4));
    }

    public static int MyPow(int n, int x) {
        int res = 1;
        for (int i = 1; i <= x; i++) {
            res *= n;
        }
        return res;
    }

    public static long MyPowRe(int n, int x) {
        if (x <= 0) return 1;
        long half = MyPowRe(n, x / 2);
        return x % 2 == 0 ? half * half : half * half * n;
    }
}
