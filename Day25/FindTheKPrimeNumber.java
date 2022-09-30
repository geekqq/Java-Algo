package Day25;

public class FindTheKPrimeNumber {
    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                count++;
                if (count == n) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
