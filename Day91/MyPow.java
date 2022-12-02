package Day91;

public class MyPow {
    public static int getPow(int n, int x) {
        if (x == 0) return 1;
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= n;
        }
        return res;
    }
    public static int getPow2(int n, int x) {
        if (x == 0) return 1;
        int half = getPow2(n, x / 2);
        return ((x & 1) == 0) ? half * half : half * half * n;
    }

    public static void main(String[] args) {
        System.out.println(getPow(5,2));
        System.out.println(getPow2(5,0));
    }
}
