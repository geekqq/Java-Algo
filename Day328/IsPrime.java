package Day328;

public class IsPrime {

    public static boolean isPrime(int n) {
        if (n <= 3) return n > 1;
        if (n % 6 != 5 && n % 6 != 1) return false;
        for (int i = 5; i <= Math.sqrt(n); i++) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1221; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
