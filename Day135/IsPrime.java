package Day135;

public class IsPrime {
    public static void main(String[] args) {
        for (int i = 0; i < 1115; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    private static boolean isPrime(int x) {
        if (x <= 3) {
            return x > 1;
        }
        if (x % 6 != 1 && x % 6 != 5) return false;
        for (int i = 5; i <= Math.sqrt(x); i += 6) {
            if (x % i == 0 || x % (i +2) == 0) {
                return false;
            }
        }
        return true;
    }
}
