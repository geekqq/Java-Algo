package Day39;

public class PrimeNumbers {
    public static void main(String[] args) {
        //print all the prime numbers within 100:
        for (int i = 0; i < 101; i++) {
            if (isPrimeNum(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrimeNum(int n) {
        if (n <= 3) {
            return n > 1;
        }

        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }

        for (int i = 5; i <= Math.sqrt(n); i++) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
