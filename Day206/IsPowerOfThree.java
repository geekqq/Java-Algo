package Day206;

public class IsPowerOfThree {

    public static boolean isPowerOfThree(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 3 != 0) return false;
        return isPowerOfThree(x / 3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isPowerOfThree(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
