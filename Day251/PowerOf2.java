package Day251;

public class PowerOf2 {

    public static boolean isPowerOf2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOf2(n / 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1025; i++) {
            if (isPowerOf2II(i)) {
                System.out.print(i + ",");
            }
        }
        System.out.println();
        for (int i = 0; i < 1025; i++) {
            if (isPowerOf2(i)) {
                System.out.print(i + ",");
            }
        }
    }

    public static boolean isPowerOf2II(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }
}
