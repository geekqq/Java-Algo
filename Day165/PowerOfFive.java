package Day165;

public class PowerOfFive {
    public static void main(String[] args) {
        System.out.println(powerOfFive(0));
        System.out.println(powerOfFive(1));
        System.out.println(powerOfFive(2));
        System.out.println(powerOfFive(5));
        System.out.println(powerOfFive(25));
        System.out.println(powerOfFive(100));
        System.out.println(powerOfFive(125));
    }

    private static boolean powerOfFive(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 5 != 0) return false;
        return powerOfFive(n / 5);
    }
}
