package Day72;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2,6));
        System.out.println(myPow2(2,6));
    }

    public static int myPow(int n, int x) {
        if (x == 0) return 1;
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= n;
        }
        return res;
    }
    public static int myPow2(int n, int x) {
        if (x == 0) return 1;
        int half = myPow2(n, x / 2);
        return x % 2 == 0 ? half * half : half * half * n;
    }
}
