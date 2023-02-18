package Day168;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(powerOfThree(3));
        System.out.println(powerOfThree(6));
        System.out.println(powerOfThree(9));
        System.out.println(powerOfThree(26));
    }

    private static boolean powerOfThree(int n) {
        if ( n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return powerOfThree(n / 3);
    }
}
