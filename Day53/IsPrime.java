package Day53;

public class IsPrime {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 3) return n > 1;
        if (n % 6 != 1 && n % 6 != 5 ) return false;
        for (int i = 5; i <= Math.sqrt(n) ; i += 6) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
