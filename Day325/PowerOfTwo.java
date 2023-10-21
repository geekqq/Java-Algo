package Day325;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 2 != 0) return false;
        return isPowerOfTwo(x / 2);
    }

    public static boolean isPowerOfThree(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 3 != 0) return false;
        return isPowerOfThree(x / 3);
    }

    public static boolean isPowerOfFour(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 4 != 0) return false;
        return isPowerOfFour(x / 4);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (isPowerOfTwo(i)) System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 1111; i++) {
            if (isPowerOfThree(i)) System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 1111; i++) {
            if (isPowerOfFour(i)) System.out.print(i + " ");
        }
        System.out.println();
    }
}
