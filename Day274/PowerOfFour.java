package Day274;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1234324523; i++) {
            if (isPowerOfFour(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
