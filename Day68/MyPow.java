package Day68;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(getPow(5,2));
        System.out.println(getPow2(5,2));
    }

    public static int getPow(int n, int x) {
        if (x < 1) return 1; //先不考虑负数的情况
        if (x == 1) return n;
        int half = getPow(n, x / 2);
        return x % 2 == 0 ? half * half : half * half * n;
    }

    public static int getPow2(int n, int x) {
        if (x < 1) return 1;
        if (x == 1) return n;
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= n;
        }
        return res;
    }
}
