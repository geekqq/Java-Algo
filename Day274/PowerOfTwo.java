package Day274;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            if (isPowerOfTwo(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
