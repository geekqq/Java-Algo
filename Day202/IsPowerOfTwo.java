package Day202;

public class IsPowerOfTwo {

    public static boolean powerOfTwo(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 2 != 0) return false;
        return powerOfTwo(x / 2);
    }

    public static boolean powerOfThree(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x %3 != 0) return false;
        return powerOfThree(x / 3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 310; i++) {
            if (powerOfThree(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
