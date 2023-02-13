package Day164;

public class PowerOfTwo {
    //LC231
    public static boolean isPowOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowOfTwo(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(isPowOfTwo(2));
        System.out.println(isPowOfTwo(4));
        System.out.println(isPowOfTwo(6));
        System.out.println(isPowOfTwo(8));
        System.out.println(isPowOfTwo(16));
        System.out.println(isPowOfTwo(15));
        System.out.println(isPowOfTwo(1000000000));
    }
}
