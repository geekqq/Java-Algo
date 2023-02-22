package Day172;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(powerOfFour(0));
        System.out.println(powerOfFour(1));
        System.out.println(powerOfFour(2));
        System.out.println(powerOfFour(4));
        System.out.println(powerOfFour(8));
    }
    private static boolean powerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return powerOfFour(n / 4);
    }
}
