package Day179;

public class PowerOfFive {
    public static void main(String[] args) {
        for (int i = 0; i < 127; i++) {
            System.out.println(i + " is power of five? " + powerOfFive(i));
        }
    }

    private static boolean powerOfFive(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 5 != 0) return false;
        return powerOfFive(n / 5);
    }
}
