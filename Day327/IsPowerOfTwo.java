package Day327;

public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12000; i++) {
            if (isPowerOfTwo(i)) System.out.println(i);
        }
    }
}
