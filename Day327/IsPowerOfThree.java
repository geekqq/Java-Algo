package Day327;

public class IsPowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1223313; i++) {
            if (isPowerOfThree(i)) System.out.println(i);
        }
    }
}
