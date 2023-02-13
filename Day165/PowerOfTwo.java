package Day165;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(1));
        System.out.println(powerOfTwo(2));
        System.out.println(powerOfTwo(3));
        System.out.println(powerOfTwo(4));
        System.out.println(powerOfTwo(8));
        System.out.println(powerOfTwo(120));
    }

    private static boolean powerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return powerOfTwo(n / 2);
    }
}
