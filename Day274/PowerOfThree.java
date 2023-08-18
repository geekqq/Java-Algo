package Day274;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1124321342; i++) {
            if (isPowerOfThree(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
