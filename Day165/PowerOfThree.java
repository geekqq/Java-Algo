package Day165;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(powerOfThree(3));
        System.out.println(powerOfThree(0));
        System.out.println(powerOfThree(1));
        System.out.println(powerOfThree(6));
        System.out.println(powerOfThree(9));
    }

    private static boolean powerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return powerOfThree(n / 3);
    }
}
