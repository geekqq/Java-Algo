package Day184;

public class PowerOfFour {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.println(i + " is power of four? " + powerOfFour(i));
        }
    }

    public static boolean powerOfFour(int x) {
        if (x <= 0) return false;
        if (x == 1) return true;
        if (x % 4 != 0) return false;
        return powerOfFour(x / 4);
    }
}
