package Day169;

public class PowerOfFour {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " is power of 4 ? " + powerOfFour(i) );
        }
    }

    private static boolean powerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return powerOfFour(n / 4);
    }
}
